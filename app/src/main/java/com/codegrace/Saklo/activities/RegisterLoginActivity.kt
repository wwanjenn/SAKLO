package com.codegrace.Saklo.activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.codegrace.Saklo.R

class RegisterLoginActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)
        changeStatusBarTextColor()

    }

    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        val navController = navHostFragment?.navController

        if (navController?.currentDestination?.id == navController?.graph?.startDestinationId) {
            if (doubleBackToExitPressedOnce) super.onBackPressed()
            else onHandlerStart()
        } else super.onBackPressed()
    }

    private fun onHandlerStart() {
        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }
}
