package com.abdelrahman.ramadan.tz_.data.repo

import com.abdelrahman.ramadan.tz_.data.remote.ApiService
import com.abdelrahman.ramadan.tz_.utils.DataTaskStats
import com.abdelrahman.ramadan.tz_.utils.LoginStats
import javax.inject.Inject
import javax.inject.Singleton

/**
 * rideId
 * Node
 * RideType
 * Gide
 * Pax
 * */

@Singleton
class AuthRepoImp @Inject constructor(private val apiService: ApiService) {
    suspend fun login(username: String, password: String): LoginStats {
        val response = apiService.authentication(username, password)
        return try {
            if (response.isSuccessful && response.body() != null && response.code() == 200) {
                var cookies = ""
                response.headers().forEach {
                    if (it.first == "Set-Cookie") {
                        cookies += it.second + ";"
                    }
                }
                cookies += response.headers()["Set-Cookie"] ?: ""

                LoginStats.Success(
                    response.body()!!.user,
                    "Bearer: ${response.body()?.user?.userId}",
                    cookies ?: ""

                )

            } else {
                LoginStats.Error(response.message())
            }
        } catch (e: Exception) {
            LoginStats.Error(e.message.toString())
        }

    }


}

