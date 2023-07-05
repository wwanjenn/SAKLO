package com.codegrace.Saklo.ui.repository

import com.codegrace.Saklo.data.room.RemediesDao

class Repository(private val remeDao: RemediesDao) {
    val remedies = remeDao.getAll()

    fun findByName(input: String) = remeDao.findByName(input)

    fun orderByCommonName() = remeDao.getEntryOrderedByNameCommon()

    fun orderByScientificName() = remeDao.getEntryOrderedByNameScientific()

    fun unorderedRemedies() = remeDao.getAll()
}