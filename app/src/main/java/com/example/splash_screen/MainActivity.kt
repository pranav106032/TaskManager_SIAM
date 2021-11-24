package com.example.splash_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isChecked=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.about)
        val button2=findViewById<Button>(R.id.login)
        val checkAnim=findViewById<LottieAnimationView>(R.id.animate)

        val video="android.resource://"+packageName+"/"+R.raw.video_preview
        val uri=Uri.parse(video)
        vid_bac.setVideoURI(uri)
        vid_bac.requestFocus()

        vid_bac.setOnPreparedListener{
            vid_bac.start()
        }

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
        checkAnim.setOnClickListener{
            if(isChecked){
                checkAnim.speed= 1f
                checkAnim.playAnimation()
                isChecked=true
            }
        }

    }
}