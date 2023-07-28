package com.codegrace.Saklo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.codegrace.Saklo.R
import org.w3c.dom.Text

class DrugsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drugs_details)

        changeStatusBarTextColor()

        val nameGeneric: String = intent.getStringExtra("nameGeneric").toString()
        val nameBrand: String = intent.getStringExtra("nameBrand").toString()
        val category: String = intent.getStringExtra("category").toString()
        val descPara: String = intent.getStringExtra("descPara").toString()
        val warnPara: String = intent.getStringExtra("warnPara").toString()

        var nameGenericTV = findViewById<TextView>(R.id.textView1)
        var nameBrandTV = findViewById<TextView>(R.id.textView2)
        var categoryTV = findViewById<TextView>(R.id.textView3)
        var descParaTV = findViewById<TextView>(R.id.textView6)
        var warnParaTV = findViewById<TextView>(R.id.textView8)

        nameGenericTV.text = nameGeneric
        nameBrandTV.text = nameBrand
        categoryTV.text = category
        descParaTV.text = descPara
        warnParaTV.text = warnPara


    }
    private fun changeStatusBarTextColor() {

        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }
}