package com.example.social.presentation.home

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.data.models.OfferModel
import com.example.social.databinding.HomeOfferFullLayoutBinding
import com.example.social.databinding.HomeOfferHalfLayoutBinding

class OfferAdapter
    : ListAdapter<OfferModel, RecyclerView.ViewHolder>(OfferModel.diffCallback) {

    private lateinit var offerFullLayoutBinding: HomeOfferFullLayoutBinding
    private lateinit var offerHalfLayoutBinding: HomeOfferHalfLayoutBinding

    override fun getItemViewType(position: Int): Int {
        return super.getItem(position).cardType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            1 -> {
                offerFullLayoutBinding =
                    HomeOfferFullLayoutBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false)
                FullViewHolder(offerFullLayoutBinding)
            }
            else -> {
                offerHalfLayoutBinding =
                    HomeOfferHalfLayoutBinding.inflate(LayoutInflater.from(parent.context),
                        parent,
                        false)
                HalfViewHolder(offerHalfLayoutBinding)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FullViewHolder) {
            holder.bind(getItem(position))
        }
        if (holder is HalfViewHolder) {
            holder.bind(getItem(position))
        }

    }


    class FullViewHolder(private val binding: HomeOfferFullLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: OfferModel) {
            binding.bModel = offer
            binding.offerTitle.setTextColor(offer.titleColor.toColorInt())
            binding.orderDetail.setTextColor(offer.startColor.toColorInt())
            binding.offerImage.load(offer.offerImage)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                intArrayOf(Color.parseColor(offer.startColor), Color.parseColor(offer.endColor))
            )
            binding.view.background = gradientDrawable
        }
    }

    class HalfViewHolder(private val binding: HomeOfferHalfLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(offer: OfferModel) {
            binding.bModel = offer
            binding.offerTitle.setTextColor(offer.titleColor.toColorInt())
            binding.offerPercent.setTextColor(offer.startColor.toColorInt())
            binding.orderDetail.setTextColor(offer.startColor.toColorInt())
            binding.offerImage.load(offer.offerImage)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                intArrayOf(Color.parseColor(offer.startColor), Color.parseColor(offer.endColor))
            )
            binding.view.background = gradientDrawable
        }
    }
}