package com.codegrace.Saklo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.codegrace.Saklo.R

class RemediesDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remedies_details)

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
}