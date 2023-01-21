package com.example.social.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.social.databinding.FragmentPostsBinding

class PostsFragment(): Fragment() {
private lateinit var binding:FragmentPostsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentPostsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}