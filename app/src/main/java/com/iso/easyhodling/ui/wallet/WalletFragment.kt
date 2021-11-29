package com.iso.easyhodling.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.EasyHodlingApp.Companion.binanceCoins
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.FragmentWalletBinding

class WalletFragment : Fragment() {

    private lateinit var walletViewModel: WalletViewModel
    private var _binding: FragmentWalletBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        walletViewModel =
            ViewModelProvider(this).get(WalletViewModel::class.java)

        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val monedas = binanceCoins.keys.toList()
        binding.totalDolaresTexto.text = getString(R.string.total_wallet) + " "
        binding.totalDolaresCantidad.text = ((walletViewModel.monedas(1) * 57000) +
                (walletViewModel.monedas(2) * 4300) + (walletViewModel.monedas(3) * 0.00004)
                + (walletViewModel.monedas(4) * 0.69) + (walletViewModel.monedas(5) * 1.57)
                + (walletViewModel.monedas(6) * 35.75) + (walletViewModel.monedas(7) * 206.56)
                + (walletViewModel.monedas(8) * 617.8) + (walletViewModel.monedas(9) * 198)).toString() + "$"

        binding.moneda1.text = monedas[0] + ":"
        binding.cantidadMoneda1.text = walletViewModel.monedas(1).toString()
        binding.cantidadDolaresMoneda1.text = (walletViewModel.monedas(1) * 57000).toString() + "$"
        binding.moneda2.text = monedas[1] + ":"
        binding.cantidadMoneda2.text = walletViewModel.monedas(2).toString()
        binding.cantidadDolaresMoneda2.text = (walletViewModel.monedas(2) * 4300).toString() + "$"
        binding.moneda3.text = monedas[2] + ":"
        binding.cantidadMoneda3.text = walletViewModel.monedas(3).toString()
        binding.cantidadDolaresMoneda3.text = (walletViewModel.monedas(3) * 0.00004).toString() + "$"
        binding.moneda4.text = monedas[3] + ":"
        binding.cantidadMoneda4.text = walletViewModel.monedas(4).toString()
        binding.cantidadDolaresMoneda4.text = (walletViewModel.monedas(4) * 0.69).toString() + "$"
        binding.moneda5.text = monedas[4] + ":"
        binding.cantidadMoneda5.text = walletViewModel.monedas(5).toString()
        binding.cantidadDolaresMoneda5.text = (walletViewModel.monedas(5) * 1.57).toString() + "$"
        binding.moneda6.text = monedas[5] + ":"
        binding.cantidadMoneda6.text = walletViewModel.monedas(6).toString()
        binding.cantidadDolaresMoneda6.text = (walletViewModel.monedas(6) * 35.75).toString() + "$"
        binding.moneda7.text = monedas[6] + ":"
        binding.cantidadMoneda7.text = walletViewModel.monedas(7).toString()
        binding.cantidadDolaresMoneda7.text = (walletViewModel.monedas(7) * 206.56).toString() + "$"
        binding.moneda8.text = monedas[7] + ":"
        binding.cantidadMoneda8.text = walletViewModel.monedas(8).toString()
        binding.cantidadDolaresMoneda8.text = (walletViewModel.monedas(8) * 617.8).toString() + "$"
        binding.moneda9.text = monedas[8] + ":"
        binding.cantidadMoneda9.text = walletViewModel.monedas(9).toString()
        binding.cantidadDolaresMoneda9.text = (walletViewModel.monedas(9) * 198).toString() + "$"


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}