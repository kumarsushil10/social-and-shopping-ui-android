package com.example.social.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.data.models.ConnectionModel
import com.example.social.databinding.HomeConnectedLayoutBinding
import com.example.social.databinding.HomeLikeLayoutBinding
import com.example.social.databinding.HomePostedLayoutBinding

class ConnectionAdapter:ListAdapter<ConnectionModel,RecyclerView.ViewHolder>(ConnectionModel.diffCallback) {
    private lateinit var likeLayoutBinding: HomeLikeLayoutBinding
    private lateinit var postedLayoutBinding: HomePostedLayoutBinding
    private lateinit var connectionLayoutBinding: HomeConnectedLayoutBinding

    override fun getItemViewType(position: Int): Int {
        return super.getItem(position).actionType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
    when (viewType) {
        1 -> {
            likeLayoutBinding = HomeLikeLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            LikeViewHolder(likeLayoutBinding)
        }
        2 -> {
            connectionLayoutBinding = HomeConnectedLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            ConnectionViewHolder(connectionLayoutBinding)
        }
        else -> {
            postedLayoutBinding = HomePostedLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            PostViewHolder(postedLayoutBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is LikeViewHolder){ holder.bind(getItem(position)) }
        if(holder is ConnectionViewHolder){ holder.bind(getItem(position)) }
        if(holder is PostViewHolder){ holder.bind(getItem(position)) }

    }

    class LikeViewHolder(private val binding: HomeLikeLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(connection:ConnectionModel){
            binding.bModel = connection
            binding.userImage.load(connection.userImage)
            binding.action.load(connection.action)
        }
    }
    class PostViewHolder(private val binding: HomePostedLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(connection:ConnectionModel){
            binding.bModel = connection
            binding.userImage.load(connection.userImage)
            binding.action.load(connection.action)
        }
    }
    class ConnectionViewHolder(private val binding: HomeConnectedLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(connection:ConnectionModel){
            binding.bModel = connection
            binding.userImage.load(connection.userImage)
        }
    }

}