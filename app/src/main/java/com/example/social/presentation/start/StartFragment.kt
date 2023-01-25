package com.example.social.presentation.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.social.R
import com.example.social.databinding.FragmentStartBinding

class StartFragment():Fragment() {
    private lateinit var binding:FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.personImage.load(R.drawable.person)
        binding.brandImage.load(R.drawable.brands)

        binding.startConstraint.setOnClickListener {
            val action = StartFragmentDirections.actionLauncherFragmentToNavMain()
            findNavController().navigate(action)
        }
    }
}