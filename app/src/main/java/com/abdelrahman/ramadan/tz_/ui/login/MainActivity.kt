package com.abdelrahman.ramadan.tz_.ui.login

import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.abdelrahman.ramadan.tz_.data.pojo.SessionManager
import com.abdelrahman.ramadan.tz_.data.remote.ApiService
import com.abdelrahman.ramadan.tz_.databinding.ActivityMainBinding
import com.abdelrahman.ramadan.tz_.ui.home.HomeActivity
import com.abdelrahman.ramadan.tz_.utils.Constant
import com.abdelrahman.ramadan.tz_.utils.LoginStats
import com.abdelrahman.ramadan.tz_.viewModels.LogInViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var api: ApiService
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<LogInViewModel>()
    private val sessionManager: SessionManager by lazy { SessionManager(this) }
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (sessionManager.fetchAuthToken() != null) {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        binding.signInBtn.setOnClickListener {
            val username = binding.signinEdEmail.editText?.text.toString()
            val password = binding.signinEdPassword.editText?.text.toString()
            if (checkValid(username, password))
                login(username, password)
        }


    }

    private fun login(username: String, password: String) {
        if (!checkInternetConnection()) {
            binding.progressBar.visibility = View.VISIBLE
            Snackbar.make(binding.root, "No Internet Connection", Snackbar.LENGTH_LONG).show()
            return
        }
        viewModel.login(username, password)
        lifecycleScope.launch {
            viewModel.loginStatsFlow.collect() { loginStats ->
                when (loginStats) {
                    is LoginStats.Success -> {
                        if (binding.rememberMeCheckBox.isChecked)
                            sessionManager.saveAuthToken(loginStats.token, loginStats.cookie)
                        Intent(this@MainActivity, HomeActivity::class.java).apply {
                            putExtra(Constant.TOKEN, loginStats.token)
                            putExtra(Constant.COOKIE, loginStats.cookie)

                        }.also {
                            startActivity(it)
                            binding.progressBar.visibility = View.GONE
                            finish()
                        }
                    }

                    is LoginStats.Error -> {
                        Snackbar.make(binding.root, loginStats.error, Snackbar.LENGTH_LONG).show()
                        Log.d(TAG, "login: ${loginStats.error}")
                        binding.progressBar.visibility = View.GONE
                    }

                    is LoginStats.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }

    }



    private fun checkValid(username: String, password: String): Boolean {

        if (username.isEmpty()) {
            binding.signinEdEmail.error = "Please enter your username"
            return false
        } else {
            binding.signinEdEmail.error = null
        }
        if (password.isEmpty()) {
            binding.signinEdPassword.error = "Please enter your password"
            return false
        } else {
            binding.signinEdPassword.error = null
        }
        return true
    }

    private fun checkInternetConnection(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting ?: false
    }
}


