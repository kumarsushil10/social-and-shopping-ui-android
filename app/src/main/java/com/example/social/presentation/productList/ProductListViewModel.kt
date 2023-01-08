package com.example.social.presentation.productList

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.social.data.models.ClothsList
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductListViewModel():ViewModel() {

     suspend fun  getJson(context: Context) = withContext(Dispatchers.IO) {
        val jsonString = Utils.readJson(context, "data/cloths.json")

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<ClothsList> = moshi.adapter(ClothsList::class.java)

        return@withContext jsonAdapter.fromJson(jsonString)
    }
}