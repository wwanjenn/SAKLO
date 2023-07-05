package com.codegrace.Saklo

import android.content.Context
import com.codegrace.Saklo.data.room.RemediesDao
import com.codegrace.Saklo.data.room.RemediesDatabase
import com.codegrace.Saklo.ui.repository.Repository

object Graph {
    lateinit var db: RemediesDatabase
        private set

    val repository by lazy {
        Repository(remeDao = db.remeDao())
    }

    fun provide(context: Context){
        db = RemediesDatabase.getDatabase(context)
    }
}