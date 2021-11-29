package com.iso.easyhodling.ui.forum

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iso.easyhodling.databinding.ForumFragmentBinding

class ForumFragment : Fragment() {


    private lateinit var forumViewModel: ForumViewModel
    private var _binding : ForumFragmentBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        forumViewModel =
            ViewModelProvider(this).get(ForumViewModel::class.java)

        _binding = ForumFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val forumBtn = binding.forumBtn
        val url = "https://groups.google.com/g/hodling"
        val uri = Uri.parse(url)
        forumBtn.setOnClickListener {startActivity(Intent(Intent.ACTION_VIEW,uri))}

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}