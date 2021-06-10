package com.erdemzengin.myapplication.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erdemzengin.myapplication.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val email = "appcent@appcent.mobi"
    private val password = "123456"
    private var isRemember = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        loginButton.setOnClickListener {
            if (email == etEmail.text.toString() && password == etPassword.text.toString()) {
                if (isRemember) {

                    rememberMe()
                }
                Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                val loginIntent = Intent(this, HomeActivity::class.java)
                startActivity(loginIntent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Giriş Başarısız!. Lütfen tekrar deneyiniz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            isRemember = isChecked
        }
    }

    private fun rememberMe(){
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        myEdit.putString("email",etEmail.text.toString())
        myEdit.putString("password",etPassword.text.toString())
        myEdit.putBoolean("isRemember",isRemember)
        myEdit.commit()
    }
}