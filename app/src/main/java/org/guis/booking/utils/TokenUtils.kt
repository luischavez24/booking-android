package org.guis.booking.utils

import android.content.Context

const val AUTH_TOKEN_PREF = "auth_token"

class TokenUtils(val applicationContext: Context){

    fun saveToken(token: String) {
        val sharedPreferences = applicationContext.getSharedPreferences("secrets", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit();
        editor.putString(AUTH_TOKEN_PREF, token)
        editor.commit()
    }

    fun getToken(): String {
        val sharedPreferences = applicationContext.getSharedPreferences("secrets", Context.MODE_PRIVATE)
        return sharedPreferences.getString(AUTH_TOKEN_PREF, "")?:throw Exception("Token not set yet!")
    }
}