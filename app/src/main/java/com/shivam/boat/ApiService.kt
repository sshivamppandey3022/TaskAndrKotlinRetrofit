package com.shivam.boat

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun  getPosts(): Call<MutableList<Model>>

}