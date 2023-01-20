package com.example.social.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.social.databinding.FragmentTaggedBinding

class TaggedFragment():Fragment() {
    private lateinit var binding: FragmentTaggedBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaggedBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}