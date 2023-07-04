package com.codegrace.Saklo

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Remedies::class],
    version = 1
)
abstract class RemediesDatabase: RoomDatabase() {
    abstract val dao: RemediesDao
}