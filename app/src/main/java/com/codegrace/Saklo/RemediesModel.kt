package com.codegrace.Saklo

import java.util.Random

data class RemediesModel(
    var id: Int = getAutoId(),
    var nameCommon: String? = "",
    var nameScientific: String? = "",
    var detailsPara: String? = ""
){
    companion object{
        fun getAutoId(): Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}
