package com.example.social.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.social.databinding.FragmentLabsBinding

class LabsFragment : Fragment() {

    private lateinit var binding: FragmentLabsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLabsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.main.setOnClickListener{
//            val action = LabsFragmentDirections.actionHomeFragmentToMainFragment()
//            findNavController().navigate(action)
//        }
//        binding.launcher.setOnClickListener {
//            val action = LabsFragmentDirections.actionHomeFragmentToLauncherFragment()
//            findNavController().navigate(action)
//        }

    }
}