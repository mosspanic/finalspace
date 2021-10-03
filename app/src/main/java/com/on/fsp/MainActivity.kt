package com.on.fsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butn = findViewById<ImageButton>(R.id.mainActivityButton)
        butn!!.setOnClickListener(View.OnClickListener {
            val data = Intent(this ,BattonActivity::class.java)
            startActivity(data)
        })
    }
}