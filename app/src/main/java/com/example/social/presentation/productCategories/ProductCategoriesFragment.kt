package com.example.social.presentation.productCategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.databinding.FragmentProductsCategoriesListBinding

class ProductCategoriesFragment : Fragment() {

    private lateinit var binding: FragmentProductsCategoriesListBinding
    private val viewModel:ProductCategoriesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductsCategoriesListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            var productList = viewModel.getJson(requireContext())
            binding.productsRecyclerView.layoutManager =GridLayoutManager(requireContext(),2)
            binding.productsRecyclerView.adapter = productList?.products?.let { ProductCategoriesAdapter(it) }
        }
    }
}
