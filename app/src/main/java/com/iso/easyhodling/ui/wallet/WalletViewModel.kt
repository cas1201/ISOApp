package com.iso.easyhodling.ui.wallet

import androidx.lifecycle.ViewModel
import com.iso.easyhodling.Binance
import com.iso.easyhodling.Coin
import java.math.BigDecimal
import java.math.RoundingMode

class WalletViewModel : ViewModel() {

    var binance = Binance
    var listaMonedas = mutableListOf<Coin>()

    fun crearListaMonedas() {
        val monedas = binance.getAccount().keys.toList()

        if (listaMonedas.isNotEmpty())
            listaMonedas.clear()

        listaMonedas.add(Coin("Total $ wallet", "", calcularTotalWallet().toString()))
        listaMonedas.add(Coin("Moneda", "Cantidad", "Cantidad en"))

        for (i in binance.getAccount().keys.indices) {
            listaMonedas.add(
                i + 2,
                Coin(
                    monedas[i],
                    redondear8Decimales(binance.getAssetBalance(monedas[i]), 8),
                    redondear8Decimales(calcularValorMonedaEnWallet(monedas[i]), 2)
                )
            )
        }
    }

    fun calcularTotalWallet(): BigDecimal {
        var total = 0.0

        for (i in binance.getAccount().keys.indices) {
            val moneda = binance.getAccount().keys.toList()[i]
            total += binance.getAssetPrice(moneda).toDouble()
        }
        return total.toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)
    }

    fun calcularValorMonedaEnWallet(moneda: String): Double? {
        return binance.getAssetBalance(moneda)?.times(binance.getAssetPrice(moneda).toDouble())
    }

    fun redondear8Decimales(cantidad: Double?, decimales: Int): String{
        return if (cantidad!!<1)
            cantidad.toBigDecimal().setScale(decimales, RoundingMode.HALF_EVEN).stripTrailingZeros().toString()
        else
            cantidad.toBigDecimal().setScale(decimales, RoundingMode.HALF_EVEN).toString()
    }
}