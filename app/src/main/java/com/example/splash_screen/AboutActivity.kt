package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val ab = supportActionBar
        ab!!.title="About"
        ab.setDisplayHomeAsUpEnabled(true)
        about_layout.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide))
    }
}