package com.on.fsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.on.fsp.ui.main.MainFragment
import com.on.fsp.utils.Resource

class BattonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batton)

        val butCharacters = findViewById<ImageButton>(R.id.imageButtonCharacters)
        butCharacters!!.setOnClickListener(View.OnClickListener {
            println("###### butCharacters")
           // try {
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        /*.replace*/.add(R.id.BattonActivity, MainFragment.newInstance())
                        .commitNow()
                }
            /*}catch (exception: Exception) {
                println("#########Resource.Exception");
            }*/

        })
        val butLocations = findViewById<ImageButton>(R.id.imageButtonLocations)
        butLocations!!.setOnClickListener(View.OnClickListener {
            println("###### butLocations")
        })
        val butQuotes = findViewById<ImageButton>(R.id.imageButtonQuotes)
        butQuotes!!.setOnClickListener(View.OnClickListener {
            println("###### butQuotes")
        })
    }
}