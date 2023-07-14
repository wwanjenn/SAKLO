package com.codegrace.Saklo.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codegrace.Saklo.HealthFacilityData
import com.codegrace.Saklo.R
import com.codegrace.Saklo.RemediesModel
import com.codegrace.Saklo.RemediesSQLiteHelper
import com.codegrace.Saklo.remediesAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class RemediesActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private lateinit var recyclerView: RecyclerView
    private var adapter: remediesAdapter? = null
    lateinit var sqLiteHelper: RemediesSQLiteHelper
    private lateinit var dataList: MutableList<RemediesModel>
    private lateinit var searchView: SearchView

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remedies)

        recyclerView = findViewById(R.id.recyclerViewHF)
        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        dataList = ArrayList()
        adapter = remediesAdapter(this, dataList)
        recyclerView.adapter = adapter

        changeStatusBarTextColor()

        sqLiteHelper = RemediesSQLiteHelper(this)

        getStudent()


        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
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
                R.id.btnDrugs -> {
                    startActivity(Intent(this, DrugsActivity::class.java))
                    true
                }

                else -> throw AssertionError()
            }
        }
        val themeColor = if (resources.configuration.isNightModeActive)
            R.color.black
        else
            R.color.white

        bottomNav.setBackgroundResource(themeColor)

    }

    private fun getStudent(){
        val remediesList = sqLiteHelper.getAllRemedies()
        adapter?.addItems(remediesList)
    }

    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }




}