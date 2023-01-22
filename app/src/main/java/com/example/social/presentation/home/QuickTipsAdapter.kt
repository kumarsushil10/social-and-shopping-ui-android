package com.example.social.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.data.models.QuickTipsModel
import com.example.social.databinding.HomeQuickTipsLayoutBinding

class QuickTipsAdapter :
    ListAdapter<QuickTipsModel, RecyclerView.ViewHolder>(QuickTipsModel.diffCallback) {
    private lateinit var binding: HomeQuickTipsLayoutBinding

    class QuickTipViewHolder(private val binding: HomeQuickTipsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quickTips: QuickTipsModel) {
            binding.bModel = quickTips
            binding.icon.load(quickTips.icon)
            binding.cardView.setCardBackgroundColor(quickTips.backgroundColor.toColorInt())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = HomeQuickTipsLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return QuickTipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is QuickTipViewHolder) {
            holder.bind(getItem(position))
        }
    }
}