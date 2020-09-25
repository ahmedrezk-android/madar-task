package com.rezk.madarsofttask.utils

import android.app.Activity
import android.content.Context

class PreferencesUtil(private val context: Context) {


    fun saveOrUpdateString(key: String, value: String) {
        val sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun getString(key: String): String? {
        val sp = context.getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE)
        return sp.getString(key, null)
    }


}

private const val PREFERENCES = "myPreferences"

