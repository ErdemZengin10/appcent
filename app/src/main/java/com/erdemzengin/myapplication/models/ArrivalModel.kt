package com.erdemzengin.myapplication.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArrivalModel(
    @SerializedName("airport")
    var airport:String?,
    @SerializedName("icao")
    var icao:String?,
    @SerializedName("estimated")
    var estimated:String?,
    @SerializedName("delay")
    var delay:Int?

):Serializable
