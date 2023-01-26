package com.example.social.presentation.shopping.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.social.databinding.FragmentCartBinding
import com.example.social.databinding.FragmentEmptyCartBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CartFragment() : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var emptyCartBinding: FragmentEmptyCartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        binding = FragmentCartBinding.inflate(layoutInflater , container,false)
//        return binding.root
        emptyCartBinding = FragmentEmptyCartBinding.inflate(layoutInflater,container,false)
        return emptyCartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.checkoutButton.setOnClickListener {
//            val bottomSheetFragment :BottomSheetDialogFragment = OrderPlaceBottomSheetFragment()
//            bottomSheetFragment.show(requireFragmentManager(), bottomSheetFragment.tag)
//        }
    }
}