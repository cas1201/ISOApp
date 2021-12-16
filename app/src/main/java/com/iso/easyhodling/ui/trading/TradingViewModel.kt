package com.iso.easyhodling.ui.trading

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.iso.easyhodling.Binance
import com.iso.easyhodling.R

class TradingViewModel : ViewModel() {
    val binance = Binance

    fun buy(context: Context, assetToSell: String, assetToBuy: String, quantityToBuy: Double){
        try {
            val quantityToUse = binance.calculateAssetConversion(assetToBuy, assetToSell) * quantityToBuy
            if (binance.coins[assetToSell]!! >= quantityToUse){
                binance.marketOrderBuy(assetToSell, assetToBuy, quantityToBuy)
                Toast.makeText(context, R.string.buy_completed, Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context, R.string.insuficient_funds, Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Toast.makeText(context, R.string.inexistent_coin, Toast.LENGTH_SHORT).show()
        }
    }

    fun sell(context: Context, assetToSell: String, assetToBuy: String, quantityToBuy: Double){
        try {
            if (binance.coins[assetToSell]!! >= quantityToBuy){
                binance.marketOrderSell(assetToSell, assetToBuy, quantityToBuy)
                Toast.makeText(context,R.string.sell_completed, Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context, R.string.insuficient_funds, Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Toast.makeText(context, R.string.inexistent_coin, Toast.LENGTH_SHORT).show()
        }
    }
}