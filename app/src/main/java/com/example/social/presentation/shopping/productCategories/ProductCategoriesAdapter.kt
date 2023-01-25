package com.example.social.presentation.shopping.productCategories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.R
import com.example.social.data.models.ProductModel
import com.example.social.databinding.ProductsCategoriesCardLayoutBinding

class ProductCategoriesAdapter :
    ListAdapter<ProductModel, RecyclerView.ViewHolder>(ProductModel.diffCallback) {

    private lateinit var binding: ProductsCategoriesCardLayoutBinding
    var onItemClick: ((ProductModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ProductsCategoriesCardLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            holder.bind(getItem(position))
            holder.itemView.setOnClickListener {
                onItemClick?.invoke(getItem(position))
            }
        }
    }

    class ProductViewHolder(private val binding: ProductsCategoriesCardLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductModel) {
            binding.bModel = product
            binding.productImage.load(product.productImage)
        }
    }


//    var onItemClick : ((ProductModel)-> Unit)? = null
//
//    fun loadData(newProductCategories: List<ProductModel>) {
//        productCategories = newProductCategories
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.products_categories_card_layout, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val product = productCategories[position]
//        holder.title.text = product.productName
//        holder.imageView.load(product.productImage)
//
//        holder.itemView.setOnClickListener(){
//            onItemClick?.invoke(product)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return productCategories.size
//    }
//
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val title: TextView = itemView.findViewById(R.id.product_name)
//        val imageView: ImageView = itemView.findViewById(R.id.product_image)
//
//    }

}