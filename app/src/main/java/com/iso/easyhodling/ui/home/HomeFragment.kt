package com.iso.easyhodling.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val assetToUse = binding.monedaParaUsar.text.toString().uppercase()
        val assetToOperate = binding.monedaAOperar.text.toString().uppercase()
        val quantity = binding.quantity.text.toString().toDouble()

        if (binding.buyButton.callOnClick()){
            homeViewModel.buy(assetToUse, assetToOperate, quantity)
            binding.operationText.text = "Se ha comprado $quantity de $assetToOperate!!"
        }
        else if (binding.sellButton.callOnClick()){
            homeViewModel.sell(assetToOperate, assetToUse, quantity)
            binding.operationText.text = "Se ha vendido $quantity de $assetToOperate!!"
        }
         */

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}