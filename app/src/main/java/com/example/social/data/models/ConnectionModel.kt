package com.example.social.data.models

import androidx.recyclerview.widget.DiffUtil

data class ConnectionModel(
    val key:String,
    val action: String,
    val actionType: Int,
    val descriptions: String,
    val userImage: String,
    val userName: String
){
    companion object {
        var diffCallback: DiffUtil.ItemCallback<ConnectionModel> =
            object : DiffUtil.ItemCallback<ConnectionModel>() {

                override fun areItemsTheSame(
                    oldItem: ConnectionModel,
                    newItem: ConnectionModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: ConnectionModel,
                    newItem: ConnectionModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}