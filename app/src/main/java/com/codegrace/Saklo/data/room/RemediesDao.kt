package com.codegrace.Saklo.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface RemediesDao {

    @Query("SELECT * FROM remedies")
    fun getAll(): Flow<List<Remedies>>

    @Query("SELECT * FROM remedies WHERE nameCommon LIKE :input OR nameScientific LIKE :input LIMIT 1")
    fun findByName(input: String): Remedies

    @Query("SELECT * FROM remedies ORDER BY nameCommon ASC")
    fun getEntryOrderedByNameCommon(): Flow<List<Remedies>>

    @Query("SELECT * FROM remedies ORDER BY nameScientific ASC")
    fun getEntryOrderedByNameScientific(): Flow<List<Remedies>>



}