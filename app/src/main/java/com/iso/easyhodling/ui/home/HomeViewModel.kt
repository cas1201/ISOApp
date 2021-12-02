package com.iso.easyhodling.ui.home

import androidx.lifecycle.ViewModel
import com.iso.easyhodling.Binance

class HomeViewModel : ViewModel() {
    val binance = Binance

    fun buy(assetToSell: String, assetToBuy: String, quantityToBuy: Double){
        binance.marketOrderBuy(assetToSell, assetToBuy, quantityToBuy)
    }

    fun sell(assetToSell: String, assetToBuy: String, quantityToBuy: Double){
        binance.marketOrderBuy(assetToSell, assetToBuy, quantityToBuy)
    }
}