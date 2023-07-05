package com.codegrace.Saklo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface RemediesDao {

    @Upsert
    fun upsertEntry(remedies: Remedies)

    @Delete
    fun deleteEntry(remedies: Remedies)

    @Query("SELECT * FROM remedies")
    fun getAll(): Flow<List<Remedies>>

    @Query("SELECT * FROM remedies WHERE nameCommon LIKE :common OR nameScientific LIKE :scientific LIMIT 1")
    fun findByName(common: String, scientific: String): Remedies

    @Query("SELECT * FROM remedies ORDER BY nameCommon ASC")
    fun getEntryOrderedByNameCommon(): Flow<List<Remedies>>

    @Query("SELECT * FROM remedies ORDER BY nameScientific ASC")
    fun getEntryOrderedByNameScientific(): Flow<List<Remedies>>



}