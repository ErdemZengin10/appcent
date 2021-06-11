package com.erdemzengin.myapplication.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AirlineModel(

    @SerializedName("name")
    var name:String?,
    @SerializedName("icao")
    var icao:String?





):Serializable
