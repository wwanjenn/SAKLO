package com.codegrace.Saklo

import org.w3c.dom.Text
import java.util.Random

data class RemediesModel(
    var id: Int = 0,
    var nameCommon: String? = null,
    var nameScientific: String? = null,
    var detailsPara: String? = null,
    var warningsPara: String? = null,
){

}
