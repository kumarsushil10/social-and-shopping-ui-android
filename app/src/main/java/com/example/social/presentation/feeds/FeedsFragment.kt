package com.example.social.presentation.feeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.databinding.FragmentFeedsBinding

class FeedsFragment:Fragment() {

    private lateinit var binding :FragmentFeedsBinding
    private val viewModel: FeedsViewModel by viewModels()
    private var mAdapter: FeedsAdapter = FeedsAdapter(ArrayList())
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(requireContext(), 3)

        binding.feedsRecyclerView.layoutManager = layoutManager
        binding.feedsRecyclerView.adapter = mAdapter

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return mAdapter.getItemViewType(position)
            }
        }

        observeFromViewModal()
        viewModel.getJson(requireContext())

    }
    private fun observeFromViewModal() {
        viewModel.feeds.observe(requireActivity()) { feed ->
            mAdapter.loadData(feed)
        }
    }
}