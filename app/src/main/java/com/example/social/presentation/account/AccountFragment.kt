package com.example.social.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.social.databinding.FragmentAccountBinding
import com.google.android.material.tabs.TabLayoutMediator

class AccountFragment():Fragment() {
    private lateinit var binding:FragmentAccountBinding
    private val viewModel:AccountViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAccountBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        viewPager.adapter = AccountPagerAdapter(requireActivity())

        TabLayoutMediator( binding.tabLayout,viewPager){ tab ,position ->
            tab.text = viewModel.tabNames[position]
        }.attach()
    }

}