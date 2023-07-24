package com.codegrace.Saklo

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream

class DrugsSQLiteHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        "${context.packageName}.database_versions",
        Context.MODE_PRIVATE
    )

    private fun installedDatabaseIsOutdated(): Boolean {
        return preferences.getInt(DATABASE_NAME, 0) < DATABASE_VERSION
    }

    private fun writeDatabaseVersionInPreferences() {
        preferences.edit().apply {
            putInt(DATABASE_NAME, DATABASE_VERSION)
            apply()
        }
    }

    private fun installDatabaseFromAssets() {
        val inputStream = context.assets.open("$ASSETS_PATH/$DATABASE_NAME.db")

        try {
            val outputFile = File(context.getDatabasePath(DATABASE_NAME).path)
            val outputStream = FileOutputStream(outputFile)

            inputStream.copyTo(outputStream)
            inputStream.close()

            outputStream.flush()
            outputStream.close()
        } catch (exception: Throwable) {
            throw RuntimeException("The $DATABASE_NAME database couldn't be installed.", exception)
        }
    }

    @Synchronized
    private fun installOrUpdateIfNecessary() {
        if (installedDatabaseIsOutdated()) {
            context.deleteDatabase(DATABASE_NAME)
            installDatabaseFromAssets()
            writeDatabaseVersionInPreferences()
        }
    }

    override fun getReadableDatabase(): SQLiteDatabase {
        installOrUpdateIfNecessary()
        return super.getReadableDatabase()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Nothing to do
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Nothing to do
    }


    fun getDrugs(): ArrayList<DrugsModel> {
        val drugsList: ArrayList<DrugsModel> = ArrayList()
        val selectQuery = "SELECT * FROM drugs"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var nameBrand: String
        var nameScientific: String
        var category: String
        var descPara: String
        var warnPara: String

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                nameBrand = cursor.getString(cursor.getColumnIndexOrThrow("nameBrand"))
                nameScientific = cursor.getString(cursor.getColumnIndexOrThrow("nameScientific"))
                category = cursor.getString(cursor.getColumnIndexOrThrow("category"))
                descPara = cursor.getString(cursor.getColumnIndexOrThrow("descPara"))
                warnPara = cursor.getString(cursor.getColumnIndexOrThrow("warnPara"))

                val drugs = DrugsModel(id = id, nameBrand = nameBrand, nameScientific = nameScientific, category = category, descPara = descPara, warnPara = warnPara)
                drugsList.add(drugs)
            } while(cursor.moveToNext())

        }
        return drugsList

    }

    companion object {
        const val ASSETS_PATH = "database"
        const val DATABASE_NAME = "drugs"
        const val DATABASE_VERSION = 1
    }

}