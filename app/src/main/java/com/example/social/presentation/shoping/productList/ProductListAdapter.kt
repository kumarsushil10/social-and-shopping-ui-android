package com.example.social.presentation.shoping.productList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.social.R
import com.example.social.data.models.Cloth

class ProductListAdapter(private var products: List<Cloth>) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    var onItemClick : ((Cloth)-> Unit)? = null

    fun loadData(newProducts: List<Cloth>) {
        products = newProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_s_item_card_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.title.text = product.title
        holder.subtitle.text = product.subtitle
        holder.price.text = product.price
        holder.image.load(product.image)

        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val subtitle: TextView = itemView.findViewById(R.id.subtitle)
        val price: TextView = itemView.findViewById(R.id.price)
        val image: ImageView = itemView.findViewById(R.id.image)
    }
}