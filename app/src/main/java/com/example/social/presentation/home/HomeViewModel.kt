package com.example.social.presentation.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.StatusModel
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class HomeViewModel:ViewModel() {
    private val _status = MutableLiveData<List<StatusModel>>()
    val status: LiveData<List<StatusModel>> = _status

    private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    fun getStatus(context: Context) {
        val jsonString = Utils.readJson(context, "data/home/status.json")
        val listType = Types.newParameterizedType(List::class.java, StatusModel::class.java)
        val adapter: JsonAdapter<List<StatusModel>> = moshi.adapter(listType)
        val feeds = adapter.fromJson(jsonString)
        _status.value = feeds!!
    }
}