package com.example.social.presentation.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.data.models.ProductList
import com.example.social.databinding.FragmentProductsListBinding
import com.example.social.domain.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductsListFragment : Fragment() {

    private lateinit var binding: FragmentProductsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductsListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            var productList = getJson()
            binding.productsRecyclerView.layoutManager =GridLayoutManager(requireContext(),2)
            binding.productsRecyclerView.adapter = productList?.products?.let { ProductsListAdapter(it) }
        }


    }
    private suspend fun  getJson() = withContext(Dispatchers.IO) {
        val jsonString = Utils.readJson(requireContext(), "data/product.json")

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<ProductList> = moshi.adapter(ProductList::class.java)
        return@withContext jsonAdapter.fromJson(jsonString)

    }
}
