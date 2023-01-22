package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class FeedsModel(
    val key:String,
    val color:String,
    val description: String,
    val post: List<String>,
    val userImage: String,
    val userName: String,
    val spanCount: Int,
){
    companion object {
        var diffCallback: DiffUtil.ItemCallback<FeedsModel> =
            object : DiffUtil.ItemCallback<FeedsModel>() {

                override fun areItemsTheSame(
                    oldItem: FeedsModel,
                    newItem: FeedsModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: FeedsModel,
                    newItem: FeedsModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}