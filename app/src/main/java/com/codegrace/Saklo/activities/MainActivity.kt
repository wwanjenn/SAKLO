package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeStatusBarTextColor()

        firebaseAuth = FirebaseAuth.getInstance()

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

        val btnDrugs = findViewById<Button>(R.id.btnDrugs)
        btnDrugs.setOnClickListener {
            val intentHerbal = Intent(this, DrugsActivity::class.java)
            startActivity(intentHerbal)
        }

        val btnLogout = findViewById<Button>(R.id.btnSignout)
        btnLogout.setOnClickListener {
            firebaseAuth!!.signOut()
            val intent = Intent(this, RegisterLoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
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

    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }
}