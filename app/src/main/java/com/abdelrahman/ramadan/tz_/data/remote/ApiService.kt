package com.abdelrahman.ramadan.tz_.data.remote

import retrofit2.Response
import com.abdelrahman.ramadan.tz_.data.pojo.data.LoginResponse
import com.abdelrahman.ramadan.tz_.data.pojo.data.ResponseDay
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {

    @POST("auth")
    suspend fun authentication(
        @Query("j_username") username: String,
        @Query("j_password") password: String
    ): Response<LoginResponse>
//    @POST("auth")
//     fun authentication2(
//        @Query("j_username") username: String,
//        @Query("j_password") password: String
//    ): Call<LoginResponse>



    @POST("tasks/07-07-2023/07-07-2023")
    suspend fun getTasks(
        @Header("Authorization") auth: String , @Header("Cookie") cookie: String
    ): Response<ResponseDay>
}

