package com.codegrace.Saklo.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
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

class DrugsActivity : AppCompatActivity(), DrugsAdapter.OnItemClickListener {
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

        val navigation = findViewById<View>(R.id.bottomNav) as BottomNavigationView
        val menu: Menu = navigation.menu
        val menuItem: MenuItem = menu.getItem(2)
        menuItem.isChecked = true

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intentAppoint = Intent(this, MainActivity::class.java)
            startActivity(intentAppoint)
        }

        recyclerView = findViewById(R.id.recyclerViewDrugs)
        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        drugsList = ArrayList<DrugsModel>()

        adapter = DrugsAdapter(this, drugsList, this)
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val isNightModeActive = resources.configuration.isNightModeActive
            val themeColor = if (isNightModeActive) {
                R.color.black
            } else {
                R.color.white
            }

            bottomNav.setBackgroundResource(themeColor)
        }

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
                continue
            }
            if (dataClass.nameScientific?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
                continue
            }
            if (dataClass.category?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
                continue
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

    override fun onItemClick(position: Int) {
        val drugsList = sqLiteHelper.getDrugs()
        val intent = Intent(this, DrugsDetailsActivity::class.java)
        intent.putExtra("nameGeneric", drugsList[position].nameScientific)
        intent.putExtra("nameBrand", drugsList[position].nameBrand)
        intent.putExtra("category", drugsList[position].category)
        intent.putExtra("descPara", drugsList[position].descPara)
        intent.putExtra("warnPara", drugsList[position].warnPara)
        startActivity(intent)

    }
}