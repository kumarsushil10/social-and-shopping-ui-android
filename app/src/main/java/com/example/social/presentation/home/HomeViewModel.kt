package com.example.social.presentation.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.social.data.models.ConnectionModel
import com.example.social.data.models.QuickTipsModel
import com.example.social.data.models.StatusModel
import com.example.social.utils.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class HomeViewModel:ViewModel() {
    private val _status = MutableLiveData<List<StatusModel>>()
    val status: LiveData<List<StatusModel>> = _status

    private val _quickTips = MutableLiveData<List<QuickTipsModel>>()
    val quickTips: LiveData<List<QuickTipsModel>> = _quickTips

    private val _connection = MutableLiveData<List<ConnectionModel>>()
    val connection: LiveData<List<ConnectionModel>> = _connection

    private val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    fun getStatus(context: Context) {
        val statusString = Utils.readJson(context, "data/home/status.json")
        val statusListType = Types.newParameterizedType(List::class.java, StatusModel::class.java)
        val statusAdapter: JsonAdapter<List<StatusModel>> = moshi.adapter(statusListType)
        val status = statusAdapter.fromJson(statusString)
        _status.value = status!!

        val quickTipsString = Utils.readJson(context, "data/home/quickTips.json")
        val quickTipsListType = Types.newParameterizedType(List::class.java, QuickTipsModel::class.java)
        val quickTipsAdapter: JsonAdapter<List<QuickTipsModel>> = moshi.adapter(quickTipsListType)
        val quickTips = quickTipsAdapter.fromJson(quickTipsString)
        _quickTips.value = quickTips!!

        val connectionString = Utils.readJson(context, "data/home/connection.json")
        val connectionListType = Types.newParameterizedType(List::class.java, ConnectionModel::class.java)
        val connectionAdapter: JsonAdapter<List<ConnectionModel>> = moshi.adapter(connectionListType)
        val connection = connectionAdapter.fromJson(connectionString)
        _connection.value = connection!!
    }

}