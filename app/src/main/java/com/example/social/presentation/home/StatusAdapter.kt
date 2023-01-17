package com.example.social.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.data.models.StatusModel
import com.example.social.databinding.HomeStatusLayoutBinding

class StatusAdapter:ListAdapter<StatusModel,RecyclerView.ViewHolder>(StatusModel.diffCallback) {

    private lateinit var binding: HomeStatusLayoutBinding

    class ViewHolder(private val binding:HomeStatusLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(status: StatusModel){
            binding.bModel = status
            binding.userImage.load(status.userImage)
            binding.statusImage.load(status.statusImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = HomeStatusLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){holder.bind(getItem(position))}
    }
}