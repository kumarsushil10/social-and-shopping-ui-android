package com.example.social.presentation.feeds

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.Feeds
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class FeedsViewModel() : ViewModel() {
    private val _feed = MutableLiveData<List<Feeds>>()
    val feeds: LiveData<List<Feeds>> = _feed

    fun getJson(context: Context) {
        val jsonString = Utils.readJson(context, "data/feeds/posts.json")
        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(List::class.java, Feeds::class.java)
        val adapter: JsonAdapter<List<Feeds>> = moshi.adapter(listType)
        val feeds = adapter.fromJson(jsonString)
        _feed.value = feeds!!
    }
}