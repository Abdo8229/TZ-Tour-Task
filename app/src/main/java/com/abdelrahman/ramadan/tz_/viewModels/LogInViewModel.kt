package com.abdelrahman.ramadan.tz_.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.ramadan.tz_.data.pojo.SessionManager
import com.abdelrahman.ramadan.tz_.data.repo.AuthRepoImp
import com.abdelrahman.ramadan.tz_.utils.LoginStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel
@Inject constructor(
    private val authRepo: AuthRepoImp,
) : ViewModel() {
    private var _loginStats: MutableStateFlow<LoginStats> = MutableStateFlow(LoginStats.Loading)
    val loginStatsFlow: StateFlow<LoginStats> = _loginStats
     fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = authRepo.login(username, password)) {
                is LoginStats.Success -> {
                    _loginStats.value = LoginStats.Success(response.user, response.token, response.cookie)
                }
                is LoginStats.Error -> {
                    _loginStats.value = LoginStats.Error(response.error)
                }
                is LoginStats.Loading -> {
                    _loginStats.value = LoginStats.Loading
                }
            }

        }

    }
}