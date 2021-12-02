package com.iso.easyhodling.ui.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iso.easyhodling.Coin
import com.iso.easyhodling.R

class WalletAdapter(val wallet: MutableList<Coin>) :
    RecyclerView.Adapter<WalletAdapter.WalletViewHolder>() {

    inner class WalletViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun updateWalletList(coin: Coin) {
            view.findViewById<TextView>(R.id.nombreMoneda).text = "${coin.moneda}:"
            view.findViewById<TextView>(R.id.cantidadMoneda).text = coin.cantidad
            view.findViewById<TextView>(R.id.precioMoneda).text = "${coin.precio} $"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WalletViewHolder(layoutInflater.inflate(R.layout.wallet_item, parent, false))
    }

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        holder.updateWalletList(wallet[position])
    }

    override fun getItemCount(): Int = wallet.size
}