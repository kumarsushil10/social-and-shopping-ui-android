package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class QuickTipsModel(
    val key:String,
    val backgroundColor: String,
    val icon: String,
    val title: String
){
    companion object {
        var diffCallback: DiffUtil.ItemCallback<QuickTipsModel> =
            object : DiffUtil.ItemCallback<QuickTipsModel>() {

                override fun areItemsTheSame(
                    oldItem: QuickTipsModel,
                    newItem: QuickTipsModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: QuickTipsModel,
                    newItem: QuickTipsModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}