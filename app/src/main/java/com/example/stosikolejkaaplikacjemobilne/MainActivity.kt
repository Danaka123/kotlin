package com.example.stosikolejkaaplikacjemobilne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var planets =  Stack<Int>();



        findViewById<Button>(R.id.pushbtn).setOnClickListener {

            var nowy = findViewById<EditText>(R.id.editTextTextPersonName).text.toString().toInt();

            planets.push(nowy);

            findViewById<TextView>(R.id.textView2).text = planets.toString();

        }

        findViewById<Button>(R.id.popbutton).setOnClickListener {

            if(planets.isEmpty()) {

                findViewById<TextView>(R.id.textView2).text = "Nie ma elementow";

            }else {

                planets.pop();

                findViewById<TextView>(R.id.textView2).text = planets.toString();

            }

        }

        findViewById<Button>(R.id.emptybtn).setOnClickListener {

            val empty : Boolean = planets.isEmpty()

            findViewById<TextView>(R.id.textView2).text = "Czy jest pusty: " + empty.toString();

        }

        findViewById<Button>(R.id.sizebtn).setOnClickListener {

            findViewById<TextView>(R.id.textView2).text = "Ilosc elementow: " + planets.size;

        }

        val kolejka: Queue<Int> = LinkedList<Int>()
        val length = Toast.LENGTH_SHORT
        var numer = 1
        var ilosc = 0

        findViewById<Button>(R.id.kolejka).setOnClickListener {
            Toast.makeText(applicationContext, "Twój numer to: " + numer, length).show()
            kolejka.add(numer)
            numer += 1
            ilosc += 1
            findViewById<TextView>(R.id.ile).text = ilosc.toString()
        }
        findViewById<Button>(R.id.usun).setOnClickListener {
            if (!kolejka.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Usunieto numer: " + kolejka.element() + " z kolejki!",
                    length
                ).show()
                kolejka.remove()
                ilosc -= 1
                findViewById<TextView>(R.id.ile).text = ilosc.toString()

            } else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show()
            }
        }
        findViewById<Button>(R.id.kolejka).setOnClickListener {
            if (!kolejka.isEmpty()) {
                val pierw = kolejka.element()
                val ost = kolejka.last()
                findViewById<TextView>(R.id.pierwszy).text = pierw.toString()
                findViewById<TextView>(R.id.ostatni_w_kolejce).text = ost.toString()
            } else {
                Toast.makeText(applicationContext, "Brak", length).show()
                findViewById<TextView>(R.id.pierwszy).text = "brak"
                findViewById<TextView>(R.id.ostatni_w_kolejce).text = "brak"
            }
        }
    }
}