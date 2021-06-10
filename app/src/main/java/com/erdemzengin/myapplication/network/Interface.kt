package com.erdemzengin.myapplication.network

import com.erdemzengin.myapplication.models.Response4Flight
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Interface {
    @GET("flights")
    fun getFlights(@Query("access_key") access_key:String): Observable<Response4Flight>
}