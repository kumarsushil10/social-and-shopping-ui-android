package com.example.social.presentation.productList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.R
import com.example.social.databinding.FragmentProductListBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProductListFragment: Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val viewModel:ProductListViewModel by viewModels()
    private  var  mAdapter :ProductListAdapter = ProductListAdapter(ArrayList())
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


        binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.productRecyclerView.adapter = mAdapter

        observeFromViewModal()
        viewModel.getJson(requireContext())

//        lifecycleScope.launchWhenCreated {
//            var productList = viewModel.getJson(requireContext())
//            if (productList != null) {
//                mAdapter = ProductListAdapter(productList.cloths)
//            }
//            binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
//            binding.productRecyclerView.adapter = mAdapter
//
//            mAdapter.onItemClick = {
//                val dialog = BottomSheetDialog(requireContext())
//                val view = layoutInflater.inflate(R.layout.product_s_item_bottom_sheet_layout, null)
//                dialog.setContentView(view)
//                dialog.show()
//            }
//        }
    }

    private fun observeFromViewModal() {
        viewModel.product.observe(requireActivity()) { products ->
            mAdapter.loadData(products)
        }
    }

}