package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codegrace.Saklo.DrugsAdapter
import com.codegrace.Saklo.DrugsModel
import com.codegrace.Saklo.DrugsSQLiteHelper
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale

class DrugsActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private lateinit var recyclerView: RecyclerView
    private var adapter: DrugsAdapter? = null
    lateinit var sqLiteHelper: DrugsSQLiteHelper
    private lateinit var drugsList: MutableList<DrugsModel>
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drugs)
        changeStatusBarTextColor()

        recyclerView = findViewById(R.id.recyclerViewReme)
        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        drugsList = ArrayList<DrugsModel>()

        adapter = DrugsAdapter(this, drugsList)
        recyclerView.adapter = adapter

        changeStatusBarTextColor()

        sqLiteHelper = DrugsSQLiteHelper(this)

        getDrugs()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })

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

    private fun getDrugs(): ArrayList<DrugsModel> {
        val drugsList = sqLiteHelper.getDrugs()
        adapter?.addItems(drugsList)
        return drugsList
    }

    private fun searchList(text: String) {

        val drugsList = getDrugs()
        val searchList = ArrayList<DrugsModel>()
        for (dataClass in drugsList) {
            if (dataClass.nameBrand?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
            }
            if (dataClass.nameScientific?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
            }
            if (dataClass.category?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
            }
        }
        adapter?.addItems(searchList)

    }

    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }
}