package com.example.social.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.social.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productCategoriesBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProductCategoriesFragment()
            findNavController().navigate(action)
        }

        binding.account.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAccountFragment()
            findNavController().navigate(action)
        }
        binding.cart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCartFragment()
            findNavController().navigate(action)
        }
        binding.feeds.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToFeedsFragment()
            findNavController().navigate(action)
        }
        binding.main.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToMainFragment()
            findNavController().navigate(action)
        }
        binding.launcher.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLauncherFragment()
            findNavController().navigate(action)
        }

    }
}