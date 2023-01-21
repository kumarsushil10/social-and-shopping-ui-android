package com.example.social.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.social.databinding.FragmentOrderedListBinding

class OrderedListFragment:Fragment() {
    private lateinit var binding: FragmentOrderedListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderedListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}