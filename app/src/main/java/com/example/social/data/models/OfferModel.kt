package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class OfferModel(
    val cardType: Int,
    val startColor: String,
    val endColor: String,
    val key: String,
    val titleColor: String,
    val offerDetails: String,
    val offerImage: String,
    val offerPercent: String,
    val offerTitle: String,
) {
    companion object {
        var diffCallback: DiffUtil.ItemCallback<OfferModel> =
            object : DiffUtil.ItemCallback<OfferModel>() {

                override fun areItemsTheSame(
                    oldItem: OfferModel,
                    newItem: OfferModel,
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: OfferModel,
                    newItem: OfferModel,
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}