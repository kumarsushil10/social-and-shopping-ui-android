package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class ClothModel(
    val key:String,
    val image: String,
    val material: String,
    val price: String,
    val quality: String,
    val size: String,
    val subtitle: String,
    val title: String
){
    companion object {
        var diffCallback: DiffUtil.ItemCallback<ClothModel> =
            object : DiffUtil.ItemCallback<ClothModel>() {

                override fun areItemsTheSame(
                    oldItem: ClothModel,
                    newItem: ClothModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: ClothModel,
                    newItem: ClothModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}