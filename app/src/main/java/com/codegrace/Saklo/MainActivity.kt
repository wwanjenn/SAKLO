package com.codegrace.Saklo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAppoint = findViewById<Button>(R.id.btnAppoint)
        btnAppoint.setOnClickListener {
            val intentAppoint = Intent(this, AppointmentActivity::class.java)
            startActivity(intentAppoint)
        }
        val btnDrugs = findViewById<Button>(R.id.btnDrugs)
        btnDrugs.setOnClickListener {
            val intentDrugs = Intent(this, RemediesActivity::class.java)
            startActivity(intentDrugs)
        }
        val btnHerbal = findViewById<Button>(R.id.btnHerbal)
        btnHerbal.setOnClickListener {
            val intentHerbal = Intent(this, RemediesActivity::class.java)
            startActivity(intentHerbal)
        }
    }
}