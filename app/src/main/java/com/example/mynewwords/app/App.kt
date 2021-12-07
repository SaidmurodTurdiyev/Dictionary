package com.example.mynewwords.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.mynewwords.data.source.local.shared.SharedDatabese
import com.example.mynewwords.utils.MyStringObjects
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val isNight = SharedDatabese.getInstaces(this).getBoolenData(MyStringObjects.DAY_NIGHT)
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        application = this
    }

    companion object {
        lateinit var application: Application
    }
}