package com.iso.easyhodling.ui.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.FragmentConfigBinding

class ConfigFragment : Fragment() {

    private lateinit var configViewModel: ConfigViewModel
    private var _binding: FragmentConfigBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        configViewModel =
            ViewModelProvider(this).get(ConfigViewModel::class.java)

        _binding = FragmentConfigBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val paramsBtn = binding.paramsBtn
        paramsBtn.setOnClickListener { Navigation.findNavController(root).navigate(R.id.nav_to_params)}

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}