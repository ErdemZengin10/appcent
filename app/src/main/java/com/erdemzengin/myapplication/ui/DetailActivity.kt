package com.erdemzengin.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erdemzengin.myapplication.R
import com.erdemzengin.myapplication.models.FlightModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        var flightModel :FlightModel?= intent.getSerializableExtra("flightModel") as FlightModel?
        val dateTime_dep = flightModel?.departure?.estimated?.subSequence(11,16)
        val dateTime_arv = flightModel?.arrival?.estimated?.subSequence(11,16)
        departure_place_short.setText(flightModel?.departure?.icao)
        arrival_place_short.setText(flightModel?.arrival?.icao)
        departure_place_long.setText(flightModel?.departure?.airport)
        arrival_place_long.setText(flightModel?.arrival?.airport)
        date_time_arv.setText(dateTime_arv)
        date_time_dep.setText(dateTime_dep)
        flight_edit.setText(flightModel?.fligt_number?.number)

        var flight_number_bigtext :String? = flightModel?.fligt_number?.flight_icao+" "+"Flight Details"


        flight_icao_bigtext.setText(flight_number_bigtext)






        if(flightModel?.departure?.terminal==null){
            terminal_edit.setText("?")
        }else{
            terminal_edit.setText(flightModel?.departure?.terminal)
        }





        if(flightModel?.departure?.delay==null){
             delay_edit.setText("0")
        }else{
            delay_edit.setText(flightModel?.departure?.delay!!)
        }

        if(flightModel?.departure?.gate==null){
            gate_edit.setText("?")

        }else{
            gate_edit.setText(flightModel?.departure?.gate)
        }







    }
}