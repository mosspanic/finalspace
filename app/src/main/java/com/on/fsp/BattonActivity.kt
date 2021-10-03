package com.on.fsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.on.fsp.ui.main.MainFragment

class BattonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batton)

        val butHaracters = findViewById<ImageButton>(R.id.imageButtonHaracters)
        butHaracters!!.setOnClickListener(View.OnClickListener {
            println("###### butHaracters")
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
            }

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