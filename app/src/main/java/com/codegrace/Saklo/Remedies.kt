package com.codegrace.Saklo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity
data class Remedies(
    val nameCommon: String,
    val nameScientific: String,
    val detailPara: String,
    val pic: Blob,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
