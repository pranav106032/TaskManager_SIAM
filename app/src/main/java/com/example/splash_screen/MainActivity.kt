package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.about)
        val button2=findViewById<Button>(R.id.login)
        val button3=findViewById<Button>(R.id.reg)

        val ab = supportActionBar
        ab!!.title="SIAM CHAPTER"

        button.setOnClickListener{
            val intent= Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}