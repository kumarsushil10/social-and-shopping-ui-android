package com.example.social.presentation.home

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.social.R
import com.example.social.databinding.FragmentMainBinding

class MainFragment:Fragment() {

    private lateinit var binding:FragmentMainBinding
    private val viewModel: HomeViewModel by viewModels()
    private var statusAdapter: StatusAdapter = StatusAdapter()
    private var quickTipsAdapter:QuickTipsAdapter = QuickTipsAdapter()

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


        binding.quickTipRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.quickTipRecyclerView.adapter = quickTipsAdapter


        val connectionText = SpannableString("Whats happening in \n your circle ? ")
        connectionText.setSpan(ForegroundColorSpan(resources.getColor(R.color.blue_text)), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.connectionTextView.textView.text = connectionText


        val offerText = SpannableString("New Offers")
        offerText.setSpan(ForegroundColorSpan(resources.getColor(R.color.blue_text)), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.offerText.textView.text = offerText




        observeFromViewModal()
        viewModel.getStatus(requireContext())
    }



    private fun observeFromViewModal() {
        viewModel.status.observe(requireActivity()) {
            statusAdapter.submitList(it)
        }

        viewModel.quickTips.observe(requireActivity()){
            quickTipsAdapter.submitList(it)
        }
    }
}