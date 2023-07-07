package com.abdelrahman.ramadan.tz_.data.repo

import com.abdelrahman.ramadan.tz_.data.remote.ApiService
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TasksDataRepoImp @Inject constructor(private val apiService: ApiService) {
    suspend fun getTasks(auth: String, cookie: String): DataTaskStats {
        val response = apiService.getTasks(auth, cookie)
        return try {
            if (response.isSuccessful && response.body() != null && response.code() == 200) {
                DataTaskStats.Success(response.body()!!)
            } else {
                DataTaskStats.Error(response.message())
            }
        }catch (e:Exception){
            DataTaskStats.Error(e.message.toString())
        }
    }
}