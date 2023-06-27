package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class RemediesActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remedies)

        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btnHome -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.btnAppoint -> {
                    startActivity(Intent(this, AppointmentActivity::class.java))
                    true
                }
                R.id.btnRemedies -> {
                    startActivity(Intent(this, RemediesActivity::class.java))
                    true
                }

                else -> throw AssertionError()
            }
        }
    }
}