package com.iso.easyhodling.ui.config

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iso.easyhodling.ShPrefs
import com.iso.easyhodling.databinding.FragmentParamsBinding

class ParamsFragment : Fragment() {

    private lateinit var paramsViewModel: ParamsViewModel
    private var _binding: FragmentParamsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paramsViewModel =
            ViewModelProvider(this).get(ParamsViewModel::class.java)

        _binding = FragmentParamsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.save.setOnClickListener { operate(inflater.context) }

        return root
    }

    fun operate(context: Context){
        val binanceCoins = ShPrefs(context).getBinance()

        val par = binding.coinPar.text.toString()
        val limit = binding.limitText.text.toString().toInt()
        val valor_moneda_previo = binanceCoins[par]

        if (valor_moneda_previo != null) {
            binanceCoins[par] = (valor_moneda_previo + limit)
        }
        binding.percentajeText.hint = binanceCoins[par].toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}