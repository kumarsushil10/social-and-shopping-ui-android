package com.example.social

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.social.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val navController = findNavController(R.id.nav_host_fragment)
//        val navController = findNavController() ?: return
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//
//            Log.d("MainActivity", "addOnDestinationChangedListener: ${destination.id}")
//            when (destination.id) {
//                R.id.nav_main -> binding.bottomNavigationView.visibility = View.VISIBLE
//                R.id.nav_feed -> binding.bottomNavigationView.visibility = View.VISIBLE
//                R.id.nav_shop -> binding.bottomNavigationView.visibility = View.VISIBLE
//                R.id.nav_account -> binding.bottomNavigationView.visibility = View.VISIBLE
//                else -> binding.bottomNavigationView.visibility = View.GONE
//            }
//        }
//
//        binding.bottomNavigationView.setupWithNavController(navController)

    }
}