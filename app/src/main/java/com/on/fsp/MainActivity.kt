package com.on.fsp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.on.fsp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {        ActivityMainBinding.inflate(layoutInflater)    }

    private val navController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("########################begin")
        setContentView(binding.root)
        println("########################setContentView(binding.root)");        //setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationView.setupWithNavController(navController);        println("########################binding.navigationView.setupWithNavController(navController)")
       /* binding.navigationView.getOrCreateBadge(R.id.home).apply {
            println("########################binding.getOrCreateBadge")
            backgroundColor = androidx.core.content.ContextCompat.getColor(this@MainActivity, R.color.purple_200);      println("######################## backgroundColor")
        };*/        println("########################binding.navigationView")

    }
}