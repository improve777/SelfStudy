package com.improve777.selfstudy

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.improve777.common.logger.Delog
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Delog.init(BuildConfig.DEBUG)
    }
}