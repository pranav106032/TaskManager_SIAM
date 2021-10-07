package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_domains.*
import kotlinx.android.synthetic.main.drawer_layout.*

class DomainsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)
        setSupportActionBar(toolbar3)
        val toggle = ActionBarDrawerToggle(this,drawer,toolbar3,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        card.setOnClickListener {
            startActivity(Intent(this,AppDomain::class.java))
        }
    }
}