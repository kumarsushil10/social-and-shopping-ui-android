package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class StatusModel(
    val cornerColor: String,
    val key: String,
    val statusImage: String,
    val userImage: String,
    val userName: String,
    val isLive:Boolean
){
    companion object {
        var diffCallback: DiffUtil.ItemCallback<StatusModel> =
            object : DiffUtil.ItemCallback<StatusModel>() {

                override fun areItemsTheSame(
                    oldItem: StatusModel,
                    newItem: StatusModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: StatusModel,
                    newItem: StatusModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}