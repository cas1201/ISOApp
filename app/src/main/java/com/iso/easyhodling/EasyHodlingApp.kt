package com.iso.easyhodling

import android.app.Application

class EasyHodlingApp : Application() {
    companion object{
        lateinit var prefs: ShPrefs
        lateinit var binanceCoins: MutableMap<String, Int>
    }

    override fun onCreate() {
        super.onCreate()
        prefs = ShPrefs(applicationContext)
        binanceCoins = mutableMapOf("BTC" to 10, "ETH" to 10, "SHIB" to 1000, "THC" to 50000,
            "ADA" to 4000, "DOT" to 100, "SOL" to 300, "BNB" to 500, "LTC" to 1000)
    }
}