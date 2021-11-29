package com.iso.easyhodling.ui.wallet

import android.content.Context
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.ShPrefs

class WalletViewModel: ViewModel() {
    fun monedas(context: Context, moneda: Int): Int {
        var cantidad = 0
        val binanceCoins = ShPrefs(context).getBinance()

        when (moneda) {
            1 -> cantidad = binanceCoins["BTC"]!!
            2 -> cantidad = binanceCoins["ETH"]!!
            3 -> cantidad = binanceCoins["SHIB"]!!
            4 -> cantidad = binanceCoins["THC"]!!
            5 -> cantidad = binanceCoins["ADA"]!!
            6 -> cantidad = binanceCoins["DOT"]!!
            7 -> cantidad = binanceCoins["SOL"]!!
            8 -> cantidad = binanceCoins["BNB"]!!
            9 -> cantidad = binanceCoins["LTC"]!!
        }
        return cantidad
    }
}