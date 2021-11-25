package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_domain_tasks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DomainTasks : AppCompatActivity() {
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private  val retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domain_tasks)
        supportActionBar!!.title = intent.getStringExtra("domain_name")
        floatingActionButton.setOnClickListener{
            startActivity(Intent(this,CreateTask::class.java))
        }
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)
       getAllTasks()
    }
    private fun getAllTasks(){
        val map = HashMap<String?,String?>()
        map["department"] = intent.getStringExtra("domain_name")
        val call = retrofitInterface!!.getTask(map)
        call!!.enqueue( object : Callback<List<TaskResult?>> {
            override fun onResponse(call:Call<List<TaskResult?>> , response: Response<List<TaskResult?>>) {
                val taskList = response.body();
                val adapter = TaskAdapter(this@DomainTasks)
                recycler.layoutManager = LinearLayoutManager(this@DomainTasks)
                adapter.updateList(taskList!!)
                recycler.adapter = adapter
            }
           override fun onFailure(call: Call<List<TaskResult?>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}