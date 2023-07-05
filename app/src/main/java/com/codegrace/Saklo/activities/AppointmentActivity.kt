package com.codegrace.Saklo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codegrace.Saklo.FacilityAdapter
import com.codegrace.Saklo.HealthFacilityData
import com.codegrace.Saklo.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AppointmentActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    private lateinit var databaseReference: DatabaseReference
    private lateinit var eventListener: ValueEventListener
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: MutableList<HealthFacilityData>
    private lateinit var adapter: FacilityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        recyclerView = findViewById(R.id.recyclerViewHF)

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager

        dataList = ArrayList()
        adapter = FacilityAdapter(this, dataList)
        recyclerView.adapter = adapter

        databaseReference = FirebaseDatabase.getInstance("https://saklo-a4e3a-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("SakloApp")

        eventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(HealthFacilityData::class.java)
                    dataClass?.key = itemSnapshot.key
                    dataClass?.let { dataList.add(it) }
                }
                adapter.notifyDataSetChanged()

                Log.d("RecyclerView", "Data list size: ${dataList.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@AppointmentActivity, "$error", Toast.LENGTH_SHORT).show()
            }

        }
        databaseReference.addValueEventListener(eventListener)

        changeStatusBarTextColor()

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

                else -> throw AssertionError()
            }
        }

    }

    private fun changeStatusBarTextColor() {
        val decorView: View = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, decorView).run {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}