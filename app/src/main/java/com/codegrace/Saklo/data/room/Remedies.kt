package com.codegrace.Saklo.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text
import java.sql.Blob

@Entity
data class Remedies(
    @ColumnInfo val nameCommon: String?,
    @ColumnInfo val nameScientific: String?,
    val detailPara: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0
)
