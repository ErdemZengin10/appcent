package com.erdemzengin.myapplication.models

import com.google.gson.annotations.SerializedName

data class Response4Flight(
    @SerializedName("data")
    var flightList:List<FlightModel>
)
