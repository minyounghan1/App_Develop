package com.hankyong.hankyongsample

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hankyong.hankyongsample.common.AppConstant
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var gson: Gson
        lateinit var preferences: MyPreferences
    }

    init {
        gson = GsonBuilder().setLenient().create()
    }

    override fun onCreate() {
        super.onCreate()

        preferences = MyPreferences(applicationContext)

        if (AppConstant.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

class MyPreferences(context: Context) {
    private val prefsFileName = "hankyong_prefs"
    val prefs: SharedPreferences = context.getSharedPreferences(prefsFileName, 0)
    var SOME_KEY: String?
        get() = prefs.getString(AppConstant.STR_USER_ID, "")
        set(value) = prefs.edit().putString(AppConstant.STR_USER_ID, value).apply()
}