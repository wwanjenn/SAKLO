package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat.finishAffinity
import com.codegrace.Saklo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

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