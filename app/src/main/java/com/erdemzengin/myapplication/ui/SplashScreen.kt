package com.erdemzengin.myapplication.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erdemzengin.myapplication.R
import java.util.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()


        if (readRememberData()){
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val mainIntent = Intent(this@SplashScreen, HomeActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }, 3000)
        }else{
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    val mainIntent = Intent(this@SplashScreen, LoginActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
            }, 3000)
        }

    }

    private fun readRememberData() : Boolean {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email","")
        val password = sharedPreferences.getString("password","")
        val isRemember = sharedPreferences.getBoolean("isRemember",false)

        if (email?.isNotEmpty() == true && password?.isNotEmpty() == true){
            return true
        }
        return false
    }
}