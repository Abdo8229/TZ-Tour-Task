package com.abdelrahman.ramadan.tz_.utils

import com.abdelrahman.ramadan.tz_.data.pojo.data.ResponseDay
import com.abdelrahman.ramadan.tz_.data.pojo.data.User

sealed class DataTaskStats{
    object Loading : DataTaskStats()
    class Success (  val responseDay: ResponseDay ): DataTaskStats()
    class Error (val error: String): DataTaskStats()
}
