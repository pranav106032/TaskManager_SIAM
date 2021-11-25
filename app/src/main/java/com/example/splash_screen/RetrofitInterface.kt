package com.example.splash_screen

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.HashMap


interface RetrofitInterface {
    @POST("/login")
    fun executeLogin(@Body map: HashMap<String?, String?>?): Call<LoginResult?>?

    @POST("/signup")
    fun executeSignup(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @POST("/tasks")
    fun addTask(@Body map:HashMap<String?,String?>?): Call<Void?>?

    @POST("/getTasks")
    fun getTask(@Body map:HashMap<String?,String?>?): Call<List<TaskResult?>>?

    @POST("/getOneTask")
    fun getOneTask(@Body map:HashMap<String?,String?>?): Call<TaskResult?>?

    @POST("/addComment")
    fun addComment(@Body map: HashMap<String?, String?>?): Call<Void?>?

    @POST("/getComments")
    fun getComments(@Body map: HashMap<String?,String?>?): Call<List<CommentResult?>>?
}