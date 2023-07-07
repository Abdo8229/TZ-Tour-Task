package com.abdelrahman.ramadan.tz_.utils

import com.abdelrahman.ramadan.tz_.data.pojo.data.User

sealed class LoginStats{
    object Loading : LoginStats()
    class Success (val user : User, val token:String, val cookie: String): LoginStats()
    class Error (val error: String): LoginStats()
}