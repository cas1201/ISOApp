package com.iso.easyhodling

import android.app.Application

class EasyHodlingApp : Application() {
    companion object {
        lateinit var prefs: ShPrefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = ShPrefs(applicationContext)
    }
}