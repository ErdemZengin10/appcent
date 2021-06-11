package com.erdemzengin.myapplication.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable

data class FlightModel(

    @SerializedName("departure")
    var departure: DepartureModel?,
    @SerializedName("arrival")
    var arrival:  ArrivalModel?,
    @SerializedName("airline")
    var airline: AirlineModel?,
    @SerializedName("flight_status")
    var flight_status: String?,
    @SerializedName("flight")
    var fligt_number: NumberModel?


):Serializable
