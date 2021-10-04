package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val ab=supportActionBar
        ab!!.title="Login Credentials"
        ab.setDisplayHomeAsUpEnabled(true)
    }
}