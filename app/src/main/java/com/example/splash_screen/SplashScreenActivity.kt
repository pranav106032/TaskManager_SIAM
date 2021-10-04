package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val sl=findViewById<ImageView>(R.id.siam_logo)

        sl.alpha=0f
        sl.animate().setDuration(3000).alpha(1f).withEndAction{
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.cycle_interpolator,android.R.anim.bounce_interpolator)
            finish()
        }
    }
}