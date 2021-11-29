package com.iso.easyhodling.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.iso.easyhodling.R
import com.iso.easyhodling.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private lateinit var helpViewModel: HelpViewModel
    private var _binding: FragmentHelpBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        helpViewModel =
            ViewModelProvider(this).get(HelpViewModel::class.java)

        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textHelp.text = getString(R.string.help)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}