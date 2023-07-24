package com.codegrace.Saklo.activities

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.codegrace.Saklo.R

class RemediesDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remedies_details)

        changeStatusBarTextColor()

        val nameCommon: String = intent.getStringExtra("nameCommon").toString()
        val nameScientific: String = intent.getStringExtra("nameScientific").toString()
        val detailsPara: String = intent.getStringExtra("detailsPara").toString()
        val warningsPara: String = intent.getStringExtra("warningsPara").toString()

        var nameCommonTV = findViewById<TextView>(R.id.textView1)
        var nameScientificTV = findViewById<TextView>(R.id.textView2)
        var detailsParaTV = findViewById<TextView>(R.id.textView4)
        var warningsParaTV = findViewById<TextView>(R.id.textView6)

        nameCommonTV.text = nameCommon
        nameScientificTV.text = nameScientific
        detailsParaTV.text = detailsPara
        warningsParaTV.text = warningsPara

    }

    private fun changeStatusBarTextColor() {

        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }

}