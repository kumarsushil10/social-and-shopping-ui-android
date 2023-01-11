package com.example.social.presentation.productCategories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.databinding.FragmentProductListBinding
import com.example.social.databinding.FragmentProductsCategoriesListBinding
import com.example.social.presentation.productList.ProductDetailsBottomSheetFragment
import com.example.social.presentation.productList.ProductListAdapter
import com.example.social.presentation.productList.ProductListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProductCategoriesFragment : Fragment() {
    private val TAG = "ProductCategoriesFragment"
    private lateinit var binding: FragmentProductsCategoriesListBinding
    private val viewModel: ProductCategoriesViewModel by viewModels()
    private var mAdapter: ProductCategoriesAdapter = ProductCategoriesAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductsCategoriesListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.productsRecyclerView.adapter = mAdapter

        observeFromViewModal()
        viewModel.getJson(requireContext())


    }

    private fun observeFromViewModal() {
        viewModel.productCategories.observe(requireActivity()) { productCategories ->
            mAdapter.loadData(productCategories)
            mAdapter.onItemClick = {
                val action = ProductCategoriesFragmentDirections.actionProductCategoriesFragmentToProductListFragment(it)
                findNavController().navigate(action)
            }
        }
    }
}
