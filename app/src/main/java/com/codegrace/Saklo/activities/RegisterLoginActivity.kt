package com.codegrace.Saklo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import com.codegrace.Saklo.R

class RegisterLoginActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)
    }

    override fun onBackPressed() {
        val manager: FragmentManager = supportFragmentManager
        val backStackEntryCount = manager.backStackEntryCount

        // Check if fragments are in the starting screen
        if (backStackEntryCount == 0) {
            if (doubleBackToExitPressedOnce) {
                finish()
            } else {
                doubleBackToExitPressedOnce = true
                Toast.makeText(
                    applicationContext,
                    "Please click back again to exit",
                    Toast.LENGTH_SHORT
                ).show()

                Handler(Looper.getMainLooper()).postDelayed({
                    doubleBackToExitPressedOnce = false
                }, 2000)
            }
        } else {
            super.onBackPressed()
        }
    }
}
