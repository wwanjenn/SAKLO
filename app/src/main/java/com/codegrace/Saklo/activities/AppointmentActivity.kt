package com.codegrace.Saklo.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codegrace.Saklo.FacilityAdapter
import com.codegrace.Saklo.HealthFacilityData
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale

class AppointmentActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    private lateinit var databaseReference: DatabaseReference
    private lateinit var eventListener: ValueEventListener
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: MutableList<HealthFacilityData>
    private lateinit var adapter: FacilityAdapter
    private lateinit var searchView:SearchView

    private var expandedPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)


        recyclerView = findViewById(R.id.recyclerViewHF)
        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        dataList = ArrayList()
        adapter = FacilityAdapter(this, dataList)

        databaseReference = FirebaseDatabase.getInstance("https://saklo-a4e3a-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Health Facilities")

        adapter.setOnItemClickListener { position ->
            expandedPosition = if (expandedPosition == position) -1 else position
            adapter.notifyDataSetChanged()
        }

        recyclerView.adapter = adapter

        eventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(HealthFacilityData::class.java)
                    dataClass?.key = itemSnapshot.key
                    dataClass?.let { dataList.add(it) }
                }
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@AppointmentActivity, "$error", Toast.LENGTH_SHORT).show()
            }

        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })

        databaseReference.addValueEventListener(eventListener)

        changeStatusBarTextColor()

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intentAppoint = Intent(this, MainActivity::class.java)
            startActivity(intentAppoint)
        }

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


        adapter.setOnItemClickListener { position ->
            if (expandedPosition == position) {
                expandedPosition = -1
            } else {
                val oldExpandedPosition = expandedPosition
                expandedPosition = position
                if (oldExpandedPosition != -1) {
                    adapter.notifyItemChanged(oldExpandedPosition)
                }
            }
            adapter.notifyItemChanged(position)
        }

    }

    private fun searchList(text: String) {
        val searchList = ArrayList<HealthFacilityData>()
        for (dataClass in dataList) {
            if (dataClass.facilityName?.lowercase(Locale.ROOT)?.contains(text.lowercase(Locale.ROOT)) == true) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }
    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        val windowInsetsController = WindowInsetsControllerCompat(window, decorView)
        windowInsetsController.isAppearanceLightStatusBars =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK != android.content.res.Configuration.UI_MODE_NIGHT_YES
    }

}