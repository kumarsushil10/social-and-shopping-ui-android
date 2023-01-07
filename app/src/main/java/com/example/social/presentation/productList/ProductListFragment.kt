package com.example.social.presentation.productList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.social.data.models.ClothsList
import com.example.social.data.models.ProductList
import com.example.social.databinding.FragmentProductListBinding
import com.example.social.domain.Utils
import com.example.social.presentation.productCategories.ProductCategoriesAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductListFragment: Fragment() {
    private lateinit var binding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            var productList = getJson()
            binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
            binding.productRecyclerView.adapter = productList?.cloths?.let { ProductListAdapter(it) }
        }
    }

    private suspend fun  getJson() = withContext(Dispatchers.IO) {
        val jsonString = Utils.readJson(requireContext(), "data/cloths.json")

        val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<ClothsList> = moshi.adapter(ClothsList::class.java)
        return@withContext jsonAdapter.fromJson(jsonString)

    }
}