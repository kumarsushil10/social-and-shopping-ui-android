package com.example.social.presentation.launcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.social.R
import com.example.social.databinding.FragmentLauncherBinding

class LauncherFragment():Fragment() {
    private lateinit var binding:FragmentLauncherBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLauncherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personImage.load(R.drawable.person)
        binding.brandImage.load(R.drawable.brands)
    }
}