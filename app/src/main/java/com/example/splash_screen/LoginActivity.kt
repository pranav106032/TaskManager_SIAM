package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login2.*
import android.view.animation.AccelerateInterpolator

import android.view.animation.AnimationSet




class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val ab=supportActionBar
        ab!!.title="Login Credentials"
        ab.setDisplayHomeAsUpEnabled(true)
        enter.setOnClickListener {
            val intent = Intent(this, DomainsActivity::class.java)
            startActivity(intent)
        }

        login_card.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_up))
        imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in))
    }
}