package com.iso.easyhodling.ui.config

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iso.easyhodling.databinding.ApisFragmentBinding

class ApisFragment : Fragment() {
    private lateinit var apisViewModel: ApisViewModel
    private var _binding: ApisFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        apisViewModel =
            ViewModelProvider(this).get(ApisViewModel::class.java)

        _binding = ApisFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}