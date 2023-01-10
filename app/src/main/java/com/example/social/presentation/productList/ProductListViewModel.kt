package com.example.social.presentation.productList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.Cloth
import com.example.social.data.models.ClothsList
import com.example.social.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductListViewModel():ViewModel() {
    private val _product = MutableLiveData<List<Cloth>>()
    val product: LiveData<List<Cloth>> = _product

      fun  getJson(context: Context)  {
        val jsonString = Utils.readJson(context, "data/cloths.json")

//        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//        val jsonAdapter: JsonAdapter<Cloth> = moshi.adapter(Cloth::class.java)
//       _product.value =  jsonAdapter.fromJson(jsonString)

          val gson = Gson()
          val listClothType = object : TypeToken<List<Cloth>>() {}.type
          val products = gson.fromJson<List<Cloth>>(jsonString, listClothType)
          _product.value = products
    }
}