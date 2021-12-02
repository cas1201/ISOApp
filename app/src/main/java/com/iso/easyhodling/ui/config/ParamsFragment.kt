package com.iso.easyhodling.ui.config

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iso.easyhodling.databinding.FragmentParamsBinding

class ParamsFragment : Fragment() {

    private lateinit var paramsViewModel: ParamsViewModel
    private var _binding: FragmentParamsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paramsViewModel =
            ViewModelProvider(this).get(ParamsViewModel::class.java)

        _binding = FragmentParamsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}