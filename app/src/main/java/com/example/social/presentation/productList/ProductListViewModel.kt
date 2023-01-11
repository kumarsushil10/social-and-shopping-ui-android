package com.example.social.presentation.productList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.Cloth
import com.example.social.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProductListViewModel() : ViewModel() {
    private val _product = MutableLiveData<List<Cloth>>()
    val product: LiveData<List<Cloth>> = _product

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/cloths.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, Cloth::class.java)
        val adapter: JsonAdapter<List<Cloth>> = moshi.adapter(listType)
        val products = adapter.fromJson(jsonString)
        _product.value = products!!


//          val gson = Gson()
//          val listClothType = object : TypeToken<List<Cloth>>() {}.type
//          val products = gson.fromJson<List<Cloth>>(jsonString, listClothType)
//          _product.value = products
    }
}