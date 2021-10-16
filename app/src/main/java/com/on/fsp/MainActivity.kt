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
    private val appBarConfiguration by lazy {
        AppBarConfiguration(setOf(
            R.id.home,
            R.id.haracters,
            R.id.locations
        ))
    }
    private val binding by lazy {        ActivityMainBinding.inflate(layoutInflater)    }

    private val navController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_main)

        //val data = Intent(this ,BattonActivity::class.java)
        /*val butn = findViewById<ImageButton>(R.id.mainActivityButton)
        butn!!.setOnClickListener(View.OnClickListener {
            val data = Intent(this ,BattonActivity::class.java)
            startActivity(data)
        })
        println("###### запуск первой активити")*/
       /* suspend { Thread.sleep(6000);   println("###### запуск первой активити after sleep")
            val data = Intent(this ,BattonActivity::class.java)
            startActivity(data)
        }*/
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