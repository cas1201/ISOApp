package com.iso.easyhodling

object Binance {
    val coins = mutableMapOf(
        "BTC" to 5.0,
        "ETH" to 10.0,
        "SHIB" to 0.0,
        "THC" to 0.0,
        "ADA" to 0.0,
        "DOT" to 0.0,
        "SOL" to 0.0,
        "BNB" to 0.0,
        "LTC" to 0.0
    )
    val coinValues = mutableMapOf(
        "BTC" to 57050.69,
        "ETH" to 4070.37,
        "SHIB" to 0.000045,
        "THC" to 0.66,
        "ADA" to 1.559,
        "DOT" to 36.79,
        "SOL" to 225.00,
        "BNB" to 628.65,
        "LTC" to 208.61
    )

    fun getAccount(): Map<String, Double> {
        return coins
    }

    fun getAssetBalance(asset: String): Double? {
        return coins[asset]
    }

    fun getAssetPrice(asset: String): String {
        return coinValues[asset].toString()
    }

    fun marketOrderBuy(assetForSell: String, assetToBuy: String, quantityToBuy: Double) {
        val newSoldQty = coins[assetForSell]?.minus(
            calculateAssetConversion(
                assetToBuy,
                assetForSell
            ) * quantityToBuy
        )
        val newBuyedQty = coins[assetToBuy]?.plus(quantityToBuy)
        coins[assetToBuy] = newBuyedQty!!
        coins[assetForSell] = newSoldQty!!
    }

    fun marketOrderSell(assetForSell: String, assetToBuy: String, quantityToSell: Double) {
        val newQty = coins[assetForSell]?.minus(quantityToSell)
        val newBuyedQty = coins[assetToBuy]?.plus(
            calculateAssetConversion(
                assetForSell,
                assetToBuy
            ) * quantityToSell
        )
        coins[assetForSell] = newQty!!
        coins[assetToBuy] = newBuyedQty!!
    }

    fun calculateAssetConversion(asset1: String, asset2: String): Double {
        val asset1Value = coinValues[asset1]!!
        val asset2Value = coinValues[asset2]!!

        return asset1Value / asset2Value
    }
}