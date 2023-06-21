package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.codegrace.Saklo.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

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

        val btnLogout = findViewById<Button>(R.id.btnSignout)
        btnLogout.setOnClickListener {
            firebaseAuth.signOut();
            val intentLogout = Intent(this, RegisterLoginActivity::class.java)
            startActivity(intentLogout)
        }
    }
}