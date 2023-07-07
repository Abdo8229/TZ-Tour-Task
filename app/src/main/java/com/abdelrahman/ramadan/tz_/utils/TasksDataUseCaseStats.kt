package com.abdelrahman.ramadan.tz_.utils

import com.abdelrahman.ramadan.tz_.data.pojo.data.TasksResponse

sealed class TasksDataUseCaseStats {
    class Success(val header : List<String>,val hashMap: HashMap<String, List<TasksResponse>>) :
        TasksDataUseCaseStats()
    class Error(val error: String) : TasksDataUseCaseStats()
    object Loading : TasksDataUseCaseStats()
}
