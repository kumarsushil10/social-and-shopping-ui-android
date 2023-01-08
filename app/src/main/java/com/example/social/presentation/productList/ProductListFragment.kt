package com.example.social.presentation.productList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.databinding.FragmentProductListBinding

class ProductListFragment: Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val viewModel:ProductListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            var productList = viewModel.getJson(requireContext())
            binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
            binding.productRecyclerView.adapter = productList?.cloths?.let { ProductListAdapter(it) }
        }
    }
}