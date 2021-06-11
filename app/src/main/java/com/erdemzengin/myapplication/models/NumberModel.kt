package com.erdemzengin.myapplication.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NumberModel(

    @SerializedName("number")
    var number:String?,
    @SerializedName("icao")
    var flight_icao:String?




):Serializable
