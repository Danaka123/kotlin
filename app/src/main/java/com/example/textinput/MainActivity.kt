package com.example.textinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        findViewById<Button>(R.id.Zatwierdź).setOnClickListener {
            val Imie = findViewById<TextInputEditText>(R.id.Imie).text.toString()
            val Nazwisko = findViewById<TextInputEditText>(R.id.Nazwisko).text.toString()

            if(Imie != "" && Nazwisko != "")
            {
                findViewById<TextView>(R.id.textView3).text = "Dane poprawne";
            }
            else
            {
                findViewById<TextView>(R.id.textView3).text = "Wypełnij wszystkie pola";
            }

        }
    }

}