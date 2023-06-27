package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.codegrace.Saklo.R

class NavBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_bar)

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intentAppoint = Intent(this, MainActivity::class.java)
            startActivity(intentAppoint)
        }

        val btnAppoint = findViewById<Button>(R.id.btnAppoint)
        btnAppoint.setOnClickListener {
            val intentAppoint = Intent(this, AppointmentActivity::class.java)
            startActivity(intentAppoint)
        }

        val btnRemedies = findViewById<Button>(R.id.btnRemedies)
        btnRemedies.setOnClickListener {
            val intentHerbal = Intent(this, RemediesActivity::class.java)
            startActivity(intentHerbal)
        }
    }
}