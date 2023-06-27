package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat.finishAffinity
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private var firebaseAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

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

        val btnLogout = findViewById<Button>(R.id.btnSignout)
        btnLogout.setOnClickListener {
            firebaseAuth!!.signOut()
            val intentLogout = Intent(this, RegisterLoginActivity::class.java)
            startActivity(intentLogout)
        }

        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
        }

        firebaseAuth?.addAuthStateListener(mAuthListener!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        firebaseAuth?.removeAuthStateListener(mAuthListener!!)
    }

    override fun onBackPressed() {
        val user = firebaseAuth?.currentUser
        handleBackPressed(user)
    }

    private fun handleBackPressed(user: FirebaseUser?) {
        if (user != null) {
            finishAffinity()
            finish()
        } else {
            startActivity(Intent(this@MainActivity, RegisterLoginActivity::class.java))
            finish()
        }
    }
}