package com.example.social.data.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val key : String,
    val productImage: String,
    val productName: String
):Parcelable{
    companion object {
        var diffCallback: DiffUtil.ItemCallback<ProductModel> =
            object : DiffUtil.ItemCallback<ProductModel>() {

                override fun areItemsTheSame(
                    oldItem: ProductModel,
                    newItem: ProductModel
                ): Boolean {
                    return oldItem.key == newItem.key
                }

                override fun areContentsTheSame(
                    oldItem: ProductModel,
                    newItem: ProductModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}