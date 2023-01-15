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

<<<<<<< HEAD
        binding.account.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAccountFragment()
=======
        binding.cart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCartFragment()
>>>>>>> feature-shoping
            findNavController().navigate(action)
        }

    }
}