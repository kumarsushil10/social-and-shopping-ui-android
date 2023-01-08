package com.example.social.presentation.productCategories

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.social.data.models.ProductList
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductCategoriesViewModel():ViewModel(){

    suspend fun  getJson(context: Context) = withContext(Dispatchers.IO) {
        val jsonString = Utils.readJson(context, "data/productCategories.json")

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<ProductList> = moshi.adapter(ProductList::class.java)

        return@withContext jsonAdapter.fromJson(jsonString)
    }
}