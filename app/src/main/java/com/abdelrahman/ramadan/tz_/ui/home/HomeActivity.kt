package com.abdelrahman.ramadan.tz_.ui.home

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.abdelrahman.ramadan.tz_.adapters.ExpandableListAdapter
import com.abdelrahman.ramadan.tz_.data.pojo.SessionManager
import com.abdelrahman.ramadan.tz_.databinding.ActivityHomeBinding
import com.abdelrahman.ramadan.tz_.utils.Constant
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import com.abdelrahman.ramadan.tz_.utils.TasksDataUseCaseStats
import com.abdelrahman.ramadan.tz_.viewModels.DataTasksViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<DataTasksViewModel>()
    private val sessionManager: SessionManager by lazy { SessionManager(this) }
    private val adapter: ExpandableListAdapter by lazy { ExpandableListAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        checkFromWhereDataCame()

    }

    private fun checkFromWhereDataCame() {
        val token = intent.extras?.getString(Constant.TOKEN)
            ?: sessionManager.fetchAuthToken()
        val cookie = intent.extras?.getString(Constant.COOKIE)
            ?: sessionManager.fetchCookie()
        if (token == null && cookie == null) {
            Snackbar.make(binding.root, "Something went wrong", Snackbar.LENGTH_LONG).show()
            return
        }
        if (!checkInternetConnection()) {
            Snackbar.make(binding.root, "No Internet Connection", Snackbar.LENGTH_LONG).show()
            return
        }

        viewModel.getTasks(token!!, cookie!!)
        lifecycleScope.launch {
            viewModel.TasksDataStatsFlow.collect {
                when (it) {
                    is TasksDataUseCaseStats.Success -> {
                        binding.expandableListViewHome.setAdapter(adapter)
                        adapter.updateData(it.header,it.hashMap)
                        binding.progressBarCircularHome.visibility = View.GONE
                    }

                    is TasksDataUseCaseStats.Error -> {
                        Snackbar.make(binding.root, it.error, Snackbar.LENGTH_LONG).show()
                        binding.progressBarCircularHome.visibility = View.GONE
                    }

                    is TasksDataUseCaseStats.Loading -> {
                        binding.progressBarCircularHome.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun checkInternetConnection(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting ?: false
    }

}