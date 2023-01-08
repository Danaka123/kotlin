package com.example.aplikacjemobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.but1_tekst).setOnClickListener {
            var text1 = findViewById<TextView>(R.id.Etykietimieinazwisko).text.toString();
            var text2 = findViewById<EditText>(R.id.Poletkst).text.toString();
            findViewById<TextView>(R.id.Etykietimieinazwisko).text = text1 + text2;
        }
        findViewById<Button>(R.id.but2_in).setOnClickListener {
            findViewById<TextView>(R.id.Etykietimieinazwisko).text = "Daniil Zayats";
        }
    }
}