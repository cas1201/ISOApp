package com.iso.easyhodling.ui.wallet

import androidx.lifecycle.ViewModel
import com.iso.easyhodling.Binance
import com.iso.easyhodling.Coin
import java.math.BigDecimal
import java.math.RoundingMode

class WalletViewModel : ViewModel() {

    val binance = Binance()

    fun crearListaMonedas(): MutableList<Coin> {
        val listaMonedas = mutableListOf<Coin>()
        val monedas = binance.getAccount().keys.toList()

        listaMonedas.add(Coin("Total $ wallet", "", calcularTotalWallet().toString()))
        listaMonedas.add(Coin("Moneda", "Cantidad", "Cantidad en"))

        for (i in binance.getAccount().keys.indices) {
            listaMonedas.add(
                i + 2,
                Coin(
                    monedas[i],
                    binance.getAssetBalance(monedas[i]).toString(),
                    calcularValorMonedaEnWallet(monedas[i]).toString()
                )
            )
        }
        return listaMonedas
    }

    fun calcularTotalWallet(): BigDecimal {
        var total = 0.0

        for (i in binance.getAccount().keys.indices) {
            var moneda = binance.getAccount().keys.toList()[i]
            total += binance.getAssetPrice(moneda).toDouble()
        }
        return total.toBigDecimal().setScale(2, RoundingMode.HALF_EVEN)
    }

    fun calcularValorMonedaEnWallet(moneda: String): BigDecimal? {
        return binance.getAssetBalance(moneda)?.times(binance.getAssetPrice(moneda).toDouble())
            ?.toBigDecimal()

    }
}