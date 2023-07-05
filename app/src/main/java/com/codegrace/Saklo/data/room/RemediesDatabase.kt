package com.codegrace.Saklo.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


@Database(
    entities = [Remedies::class],
    version = 1,
    exportSchema = false
)
abstract class RemediesDatabase: RoomDatabase() {
    abstract fun remeDao(): RemediesDao

    companion object{
        @Volatile
        private var INSTANCE: RemediesDatabase? = null

        fun getDatabase(context: Context): RemediesDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    RemediesDatabase::class.java,
                    "remedies_database"
                ).createFromFile(File("remediesdb")).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}