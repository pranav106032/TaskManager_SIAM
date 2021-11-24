package com.example.splash_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_domain_tasks.*
import kotlinx.android.synthetic.main.activity_query.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QueryActivity : AppCompatActivity() {
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private  val retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)
        setUpLayout()
        setUpComments()
        button.setOnClickListener {
            addComment()
        }
    }
    private fun setUpLayout(){
        val map = HashMap<String?,String?>()
        map["_id"] = intent.getStringExtra("task_id")
        val call = retrofitInterface!!.getOneTask(map)
        call!!.enqueue( object : Callback<TaskResult?> {
            override fun onResponse(call: Call<TaskResult?>, response: Response<TaskResult?>) {
                if(response.code() == 200) {
                    val task = response.body()
                    textView15.text = task!!.department
                    textView17.text = task.description
                }else if(response.code() == 404){
                    Toast.makeText(this@QueryActivity,"Some error occured",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<TaskResult?>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

    private  fun addComment(){
        val map = HashMap<String?,String?>()
        map["_id"] = intent.getStringExtra("task_id")
        map["name"] = "Aditya"
        map["text"] = comment.text.toString()
        val call = retrofitInterface!!.addComment(map)
        call!!.enqueue( object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if(response.code() == 200) {
                    Toast.makeText(this@QueryActivity,"Comment added successfully"+response.code(),Toast.LENGTH_SHORT).show()
                    setUpComments()
                }else if(response.code() == 404){
                    Toast.makeText(this@QueryActivity,"Some error occured",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

    private fun setUpComments(){
        val map = HashMap<String?,String?>()
        map["_id"] = intent.getStringExtra("task_id")
        val call = retrofitInterface!!.getComments(map)
        call!!.enqueue( object : Callback<List<CommentResult?>> {
            override fun onResponse(call:Call<List<CommentResult?>> , response: Response<List<CommentResult?>>) {
                if(response.code() == 200){
                    val list  = response.body()
                    val adapter = CommentsAdapter(this@QueryActivity)
                    comments_recycler.layoutManager = LinearLayoutManager(this@QueryActivity)
                    adapter.updateList(list!!)
                    comments_recycler.adapter = adapter
                }else if(response.code() == 404){
                    Toast.makeText(this@QueryActivity,"Some error occured",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<CommentResult?>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}