package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login2.*
import android.view.animation.AccelerateInterpolator

import android.view.animation.AnimationSet
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.Toast

import android.widget.EditText
import androidx.appcompat.app.AlertDialog





class LoginActivity : AppCompatActivity() {
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private  val retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)

        val ab=supportActionBar
        ab!!.title="Login Credentials"
        ab.setDisplayHomeAsUpEnabled(true)
        enter.setOnClickListener {
            val intent = Intent(this, DomainsActivity::class.java)
            startActivity(intent)
        }

        login_card.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_up))
        imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in))
//       enter.setOnClickListener {
//             handleLoginDialog()
//        }

    }
    private fun handleLoginDialog() {
        val emailEdit: EditText = email
        val passwordEdit: EditText = pass
                val map = HashMap<String?, String?>()
                map["email"] = emailEdit.text.toString()
                map["password"] = passwordEdit.text.toString()
                val call = retrofitInterface!!.executeLogin(map)
                call!!.enqueue(object : Callback<LoginResult?> {
                    override fun onResponse(
                        call: Call<LoginResult?>,
                        response: Response<LoginResult?>
                    ) {
                        if (response.code() == 200) {
                            val result = response.body()
                            Toast.makeText(this@LoginActivity,"Welcome "+result!!.name,Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@LoginActivity,DomainsActivity::class.java))
                        } else if (response.code() == 404) {
                            Toast.makeText(this@LoginActivity, "Wrong Credentials",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResult?>, t: Throwable) {
                        Toast.makeText(
                            this@LoginActivity, t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }



}