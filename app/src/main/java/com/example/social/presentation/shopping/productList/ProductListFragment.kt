package com.example.social.presentation.shopping.productList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import com.example.social.databinding.FragmentProductListBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProductListFragment : Fragment() {

    private val TAG = "ProductListFragment"
    private lateinit var binding: FragmentProductListBinding
    private val viewModel: ProductListViewModel by viewModels()
    private var mAdapter: ProductListAdapter = ProductListAdapter()
    private val args:ProductListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productIcon.load(args.products.productImage)
        binding.productTitle.text = args.products.productName

        binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.productRecyclerView.adapter = mAdapter

        observeFromViewModal()
        viewModel.getJson(requireContext())


    }

    private fun observeFromViewModal() {
        viewModel.product.observe(requireActivity()) {
            mAdapter.submitList(it)
            mAdapter.onItemClick = {
                val bottomSheetFragment: BottomSheetDialogFragment = ProductDetailsBottomSheetFragment(it)
                bottomSheetFragment.show(requireFragmentManager(), bottomSheetFragment.tag)
                Log.i(TAG, "on item Clicked:  ${it.title}")
            }
        }
    }
}