package com.example.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_task.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.HashMap

class CreateTask : AppCompatActivity() {
    private var retrofitInterface: RetrofitInterface? = null
    private val BASE_URL = "http://10.0.2.2:3000"
    private  val retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
        retrofitInterface = retrofit!!.create(RetrofitInterface::class.java)
        // get reference to the string array that we just created
        val languages = resources.getStringArray(R.array.programming_languages)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)

        add_task.setOnClickListener {
            addPost()
        }
    }

    private fun addPost(){
        val department = autoCompleteTextView.text
        val description = editTextTextPersonName.text
        val map = HashMap<String?, String?>()
        map["department"] = department.toString()
        map["description"] = description.toString()
        val call = retrofitInterface!!.addTask(map)
        call!!.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                    Toast.makeText(
                        this@CreateTask,
                        "Task added successfully" + response.code(), Toast.LENGTH_LONG
                    ).show()
                startActivity(Intent(this@CreateTask,DomainsActivity::class.java))
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Toast.makeText(
                    this@CreateTask, t.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}