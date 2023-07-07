package com.abdelrahman.ramadan.tz_.data.pojo

import android.content.Context
import android.content.SharedPreferences
import com.abdelrahman.ramadan.tz_.R
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager(@ApplicationContext context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_COOKIE = "user_cookie"

    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String, cookie: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.putString(USER_COOKIE, cookie)

        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)

    }
    /**
     * Function to fetch auth cookie
     */
    fun fetchCookie(): String? {
        return prefs.getString(USER_COOKIE, null)

    }
}

