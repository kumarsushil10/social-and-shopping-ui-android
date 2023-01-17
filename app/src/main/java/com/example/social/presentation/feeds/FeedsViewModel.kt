package com.example.social.presentation.feeds

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.FeedsModel
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class FeedsViewModel() : ViewModel() {
    private val _feed = MutableLiveData<List<FeedsModel>>()
    val feeds: LiveData<List<FeedsModel>> = _feed

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/feeds/posts.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, FeedsModel::class.java)
        val adapter: JsonAdapter<List<FeedsModel>> = moshi.adapter(listType)
        val feeds = adapter.fromJson(jsonString)
        _feed.value = feeds!!
    }
}