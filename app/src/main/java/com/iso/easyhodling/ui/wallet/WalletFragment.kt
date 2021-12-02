package com.iso.easyhodling.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.iso.easyhodling.Binance
import com.iso.easyhodling.Coin
import com.iso.easyhodling.R

class WalletFragment : Fragment() {

    private lateinit var walletViewModel: WalletViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        walletViewModel =
            ViewModelProvider(this).get(WalletViewModel::class.java)
        walletViewModel.crearListaMonedas()

        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var lista = walletViewModel.listaMonedas

        val walletRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        var adapter = WalletAdapter(lista)

        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        walletRecyclerView.layoutManager = layoutManager
        walletRecyclerView.adapter = adapter
    }
}