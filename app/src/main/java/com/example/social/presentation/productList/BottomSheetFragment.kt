package com.example.social.presentation.productList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.social.data.models.Cloth
import com.example.social.databinding.ProductSItemBottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(private val cloth:Cloth): BottomSheetDialogFragment() {
    private lateinit var binding: ProductSItemBottomSheetLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductSItemBottomSheetLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.image.load(cloth.image)
        binding.title.text = cloth.title
        binding.subtitle.text = cloth.subtitle
        binding.material.text = cloth.material
        binding.quality.text = cloth.quality
        binding.size.text = cloth.size
        binding.price.text = cloth.price

    }
}