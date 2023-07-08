package com.abdelrahman.ramadan.tz_.di

import android.util.Log
import com.abdelrahman.ramadan.tz_.data.remote.ApiService
import com.abdelrahman.ramadan.tz_.utils.Constant
import com.jakewharton.retrofit2.adapter.rxjava2.Result.response
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import org.json.XML.toJSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.nio.charset.Charset
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(
//        interceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(15, java.util.concurrent.TimeUnit.MINUTES)
            .connectTimeout(15, java.util.concurrent.TimeUnit.MINUTES)
            .callTimeout(15, java.util.concurrent.TimeUnit.MINUTES)
            .readTimeout(15, java.util.concurrent.TimeUnit.MINUTES)
            .writeTimeout(15, java.util.concurrent.TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
//            .addInterceptor(interceptor)
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))

            /***     .authenticator(object : okhttp3.Authenticator {
            override fun authenticate(route: okhttp3.Route?, response: okhttp3.Response): Request? {
            if (response.request.header("Authorization") != null) {
            return null
            }
            return response.request.newBuilder().header("Authorization", "Bearer " + 4149660).build()
            }
            })
             */
            .build()
    }

//    @Provides
//    @Singleton
//    fun providesInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val originalResponse = chain.proceed(chain.request())
//
//            val source: BufferedSource? = originalResponse.body?.source()
//            source?.request(Long.MAX_VALUE) // Buffer the entire body.
//            val buffer: Buffer = source?.buffer()!!
//            val responseBodyString: String = buffer.clone().readString(Charset.forName("UTF-8"))
//            val xmlJSONObj = toJSONObject(responseBodyString)
//            val jsonPrettyPrintString = xmlJSONObj.toString()
//            val modifiedBody =
//                ResponseBody.create(originalResponse.body?.contentType(), jsonPrettyPrintString)
//            showJson(modifiedBody)
//            val newResponse = originalResponse.newBuilder()
//                .body(modifiedBody)
//                .build()
//            newResponse
//        }
//
//    }
//    fun showJson(responseBody:ResponseBody ){
//        val source: BufferedSource? = responseBody.source()
//        source?.request(Long.MAX_VALUE) // Buffer the entire body.
//        val buffer: Buffer = source?.buffer()!!
//        val responseBodyString: String = buffer.clone().readString(Charset.forName("UTF-8"))
//        Log.d("AAAAAAAAAAA", "showJson:${responseBodyString} ")
//
//    }


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(okHttpClient)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}