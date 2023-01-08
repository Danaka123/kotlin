package com.example.calendarview

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.get
import java.time.LocalDate
import java.time.Year
import java.time.ZoneId
import java.util.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clndView = findViewById<CalendarView>(R.id.calendarView)
        var wyjbtn = findViewById<Button>(R.id.wyjbtn)
        var przybtn = findViewById<Button>(R.id.przybtn)
        var wyjlbl = findViewById<TextView>(R.id.wyjlbl)
        var przylbl = findViewById<TextView>(R.id.przylbl)
        var ilosclbl = findViewById<TextView>(R.id.ilosclbl)

        clndView.minDate = System.currentTimeMillis()
        clndView.maxDate = LocalDate.now().plusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()

        val calendar = Calendar.getInstance()
        var odjazdDate = mutableListOf<Int>(0,0,0)
        var przyjazdDate = mutableListOf<Int>(0,0,0)
        var currentDate = arrayListOf<Int>(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))


        fun obliczanie(przyjazdDate : MutableList<Int>, odjazdDate : MutableList<Int>) {
            if(przyjazdDate[0] != 0 && odjazdDate[0] != 0) {
                if(odjazdDate[2] > przyjazdDate[2]  && odjazdDate[1] == przyjazdDate[1])
                    ilosclbl.text = "Nie można cofnąć się w czasie"
                else {
                    var przyjazd = (przyjazdDate[0]*360) + (przyjazdDate[1]*30) + przyjazdDate[2]
                    var wyjazd = (odjazdDate[0]*360) + (odjazdDate[1]*30) + odjazdDate[2]
                    var ilosc = przyjazd.toChar() - wyjazd.toChar()
                    if(ilosc == 0)
                        ilosclbl.text = "Powrót tego samego dnia"
                    else if(ilosc == 1)
                        ilosclbl.text = "Długość wycieczki: 1 dzień"
                    else
                        ilosclbl.text = "Długość wycieczki: " + ilosc.absoluteValue.toString() + " dni"
                }
            }
        }

        clndView.setOnDateChangeListener() { CalendarView, x1, x2, x3 ->
            currentDate[0] = x1
            currentDate[1] = x2 + 1
            currentDate[2] = x3
        }

        wyjbtn.setOnClickListener {
            odjazdDate[0] = currentDate[0]
            odjazdDate[1] = currentDate[1]
            odjazdDate[2] = currentDate[2]
            wyjlbl.text = "Wyjazd: " + odjazdDate[0] + "." + odjazdDate[1] + "." + odjazdDate[2]
            obliczanie(przyjazdDate, odjazdDate)
        }

        przybtn.setOnClickListener {
            przyjazdDate[0] = currentDate[0]
            przyjazdDate[1] = currentDate[1]
            przyjazdDate[2] = currentDate[2]
            przylbl.text = "Przyjazd: " + przyjazdDate[0] + "." + przyjazdDate[1] + "." + przyjazdDate[2]
            obliczanie(przyjazdDate, odjazdDate)
        }


    }
}