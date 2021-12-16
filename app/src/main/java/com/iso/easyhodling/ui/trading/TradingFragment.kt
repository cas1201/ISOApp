package com.iso.easyhodling.ui.trading

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.TradingFragmentBinding

class TradingFragment : Fragment() {
    private lateinit var tradingViewModel: TradingViewModel
    private var _binding: TradingFragmentBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tradingViewModel =
            ViewModelProvider(this).get(TradingViewModel::class.java)

        _binding = TradingFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buyButton.setOnClickListener {
            var assetToUse = binding.monedaParaUsar.text.toString().uppercase()
            var assetToOperate = binding.monedaAOperar.text.toString().uppercase()
            var quantity = binding.quantity.text.toString()
            tradingViewModel.buy(requireContext(), assetToUse, assetToOperate, quantity.toDouble())
        }
        binding.sellButton.setOnClickListener {
            var assetToUse = binding.monedaParaUsar.text.toString().uppercase()
            var assetToOperate = binding.monedaAOperar.text.toString().uppercase()
            var quantity = binding.quantity.text.toString()
            tradingViewModel.sell(requireContext(), assetToOperate, assetToUse, quantity.toDouble())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}