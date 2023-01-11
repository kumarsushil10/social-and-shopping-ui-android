package com.example.social.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val productImage: String,
    val productName: String
):Parcelable