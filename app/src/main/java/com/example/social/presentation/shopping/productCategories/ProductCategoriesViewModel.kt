package com.example.social.presentation.shopping.productCategories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.ProductModel
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProductCategoriesViewModel():ViewModel(){
    private val _productCategories = MutableLiveData<List<ProductModel>>()
    val productCategories: LiveData<List<ProductModel>> = _productCategories

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/shopping/productCategories.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, ProductModel::class.java)
        val adapter: JsonAdapter<List<ProductModel>> = moshi.adapter(listType)
        val productCategories = adapter.fromJson(jsonString)
        _productCategories.value = productCategories!!
    }
}