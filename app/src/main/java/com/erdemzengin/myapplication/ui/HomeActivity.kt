package com.erdemzengin.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdemzengin.myapplication.R
import com.erdemzengin.myapplication.adapter.rvAdapter
import com.erdemzengin.myapplication.models.FlightModel
import com.erdemzengin.myapplication.models.Response4Flight
import com.erdemzengin.myapplication.network.ApiClient
import com.erdemzengin.myapplication.network.Interface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),rvAdapter.Listener {
    lateinit var flightService: Interface
    private var recyclerViewAdapter4Flight: rvAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        flightService= ApiClient.getClient().create(Interface::class.java)

        val layoutManager: RecyclerView.LayoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager
        api()


    }


    fun api(){
        var postObservable=flightService.getFlights("bcd0ed3824668a2547868cc3ce681e87")
        postObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleDataResult,this::handleError)


    }
    fun handleDataResult(data:Response4Flight){

        recyclerViewAdapter4Flight= rvAdapter(data.flightList,this@HomeActivity)
        recyclerView.adapter=recyclerViewAdapter4Flight

    }
    fun handleError(throwable: Throwable){
        println(throwable.localizedMessage)

    }
    override fun onItemClick(flightModel: FlightModel) {

        var intent= Intent(this@HomeActivity,DetailActivity::class.java)
        intent.putExtra("flightModel",flightModel)
        startActivity(intent)
    }
}