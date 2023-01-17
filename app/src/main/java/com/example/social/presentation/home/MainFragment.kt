package com.example.social.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.social.databinding.FragmentMainBinding

class MainFragment:Fragment() {

    private lateinit var binding:FragmentMainBinding
    private val viewModel: HomeViewModel by viewModels()
    private var statusAdapter: StatusAdapter = StatusAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.statusRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.statusRecyclerView.adapter = statusAdapter


        observeFromViewModal()
        viewModel.getStatus(requireContext())
    }
    private fun observeFromViewModal() {
        viewModel.status.observe(requireActivity()) {
            statusAdapter.submitList(it)
        }
    }
}