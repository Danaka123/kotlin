package com.example.projekt24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            findViewById<ImageView>(R.id.obrazek1).setImageResource(R.drawable.kot)
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            findViewById<ImageView>(R.id.obrazek1).setImageResource(R.drawable.pies)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            findViewById<ImageView>(R.id.obrazek1).setImageResource(R.drawable.lis)
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            findViewById<ImageView>(R.id.obrazek1).setImageResource(R.drawable.niedzwiedz)
        }
    }
}