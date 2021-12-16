package com.iso.easyhodling.ui.learning

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.databinding.FragmentLearningBinding

class LearningFragment: Fragment() {
    private lateinit var learningViewModel: LearningViewModel
    private var _binding : FragmentLearningBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        learningViewModel =
            ViewModelProvider(this).get(LearningViewModel::class.java)

        _binding = FragmentLearningBinding.inflate(inflater, container, false)
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