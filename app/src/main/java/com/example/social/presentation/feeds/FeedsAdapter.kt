package com.example.social.presentation.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.data.models.Cloth
import com.example.social.data.models.Feeds
import com.example.social.databinding.FeedsArticleLayoutBinding
import com.example.social.databinding.FeedsImageLayoutBinding
import com.example.social.databinding.FeedsReelLayoutBinding

class FeedsAdapter(private var feeds : List<Feeds>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var bindingImageLayout: FeedsImageLayoutBinding
    private lateinit var bindingReelLayout: FeedsReelLayoutBinding
    private lateinit var bindingArticleLayout: FeedsArticleLayoutBinding

    fun loadData(newFeeds : List<Feeds>) {
       feeds = newFeeds
        notifyDataSetChanged()
    }


    override fun getItemViewType(position: Int): Int {
        return feeds[position].spanCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
           1 -> {
                bindingReelLayout = FeedsReelLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
              ReelViewHolder(bindingReelLayout)
            }
          2 -> {
                bindingImageLayout = FeedsImageLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ImageViewHolder(bindingImageLayout)
            }
            else -> {
               bindingArticleLayout = FeedsArticleLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ArticleViewHolder(bindingArticleLayout)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ReelViewHolder){ holder.bind(feeds[position]) }
        if(holder is ImageViewHolder){ holder.bind(feeds[position]) }
        if(holder is ArticleViewHolder){ holder.bind(feeds[position]) }
    }




    override fun getItemCount(): Int {
        return feeds.size
    }



    class ReelViewHolder(private val binding: FeedsReelLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(feeds: Feeds){
            binding.bModel = feeds
            binding.userImage.load(feeds.userImage)
            binding.reel.load(feeds.post[0])
        }

    }
    class ImageViewHolder(private val binding: FeedsImageLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(feeds: Feeds){
            binding.bModel = feeds
            binding.userImage.load(feeds.userImage)
            binding.image.load(feeds.post[0])

        }
    }
    class ArticleViewHolder(private val binding: FeedsArticleLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(feeds: Feeds){
            binding.bModel = feeds
            binding.userImage.load(feeds.userImage)
            binding.image.load(feeds.post[0])
            binding.image2.load(feeds.post[1])
            binding.image3.load(feeds.post[2])

        }
    }
}