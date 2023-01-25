package com.example.social.presentation.shopping.productList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.ClothModel
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProductListViewModel() : ViewModel() {
    private val _product = MutableLiveData<List<ClothModel>>()
    val product: LiveData<List<ClothModel>> = _product

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/shopping/cloths.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, ClothModel::class.java)
        val adapter: JsonAdapter<List<ClothModel>> = moshi.adapter(listType)
        val products = adapter.fromJson(jsonString)
        _product.value = products!!


//          val gson = Gson()
//          val listClothType = object : TypeToken<List<Cloth>>() {}.type
//          val products = gson.fromJson<List<Cloth>>(jsonString, listClothType)
//          _product.value = products
    }
}