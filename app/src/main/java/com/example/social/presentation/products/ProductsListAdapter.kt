package com.example.social.presentation.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.R
import com.example.social.data.models.Product

class ProductsListAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.products_card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.title.text = product.productName
        holder.imageView.load(product.productImage)
//        holder.imageView.setImageResource(product.productImage)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.product_name)
        val imageView: ImageView = itemView.findViewById(R.id.product_image)

    }
}