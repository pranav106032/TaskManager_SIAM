package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val ab = supportActionBar
        ab!!.title="About"
        ab.setDisplayHomeAsUpEnabled(true)
    }
}