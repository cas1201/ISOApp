package com.iso.easyhodling.ui.trading

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.databinding.ForumFragmentBinding
import com.iso.easyhodling.databinding.TradingFragmentBinding
import com.iso.easyhodling.ui.forum.ForumViewModel

class TradingFragment: Fragment() {
    private lateinit var tradingViewModel: TradingViewModel
    private var _binding : TradingFragmentBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        tradingViewModel =
            ViewModelProvider(this).get(TradingViewModel::class.java)

        _binding = TradingFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val tradingBtn = binding.tradingBtn
        val url = "https://academy.binance.com/es"
        val uri = Uri.parse(url)
        tradingBtn.setOnClickListener {startActivity(Intent(Intent.ACTION_VIEW,uri))}

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}