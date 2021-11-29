package com.iso.easyhodling.ui.wallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.EasyHodlingApp.Companion.binanceCoins

class WalletViewModel: ViewModel() {
    fun monedas(moneda: Int): Int{
        var cantidad = 0

        when(moneda){
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