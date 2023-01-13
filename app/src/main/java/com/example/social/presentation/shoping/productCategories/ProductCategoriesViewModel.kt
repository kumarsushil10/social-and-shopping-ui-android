package com.example.social.presentation.shoping.productCategories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.Product
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProductCategoriesViewModel():ViewModel(){
    private val _productCategories = MutableLiveData<List<Product>>()
    val productCategories: LiveData<List<Product>> = _productCategories

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/shopping/productCategories.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, Product::class.java)
        val adapter: JsonAdapter<List<Product>> = moshi.adapter(listType)
        val productCategories = adapter.fromJson(jsonString)
        _productCategories.value = productCategories!!
    }
}