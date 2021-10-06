package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AppDomain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task)
        supportActionBar!!.title = "App Domain"
    }
}