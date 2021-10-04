package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val mail=findViewById<EditText>(R.id.idconfirm)

        val ab=supportActionBar
        ab!!.title="Step 1"
        ab.setDisplayHomeAsUpEnabled(true)
    }
}