package com.codegrace.Saklo.data.room.remedies

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Remedies::class],
    version = 1
)
abstract class RemediesDatabase: RoomDatabase() {
    abstract val dao: RemediesDao

    companion object{
        @Volatile
        private var INSTANCE: RemediesDatabase? = null

        fun getDatabase(context: Context): RemediesDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RemediesDatabase::class.java,
                    "remedies_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}