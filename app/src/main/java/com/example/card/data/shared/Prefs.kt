package com.example.card.data.shared

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Prefs(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("prefs", MODE_PRIVATE)

    fun isShow() : Boolean {
        return prefs.getBoolean("onBoard", false)
    }

    fun changeShow(show: Boolean) {
        prefs.edit().putBoolean("onBoard", show).apply()
    }

    fun saveName(name: String) {
        prefs.edit().putString("name", name).apply()
    }

    fun showName(): String {
        return prefs.getString("name", "no User").toString()
    }
}