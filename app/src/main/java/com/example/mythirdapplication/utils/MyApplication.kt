package com.example.mythirdapplication.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        private const val ONESIGNAL_APP_ID = "3aea2af5-32ae-4489-9585-ec1c64d38879"
    }

    override fun onCreate() {
        super.onCreate()

        TODO()
//        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
//
//        OneSignal.initWithContext(this)
//        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

}