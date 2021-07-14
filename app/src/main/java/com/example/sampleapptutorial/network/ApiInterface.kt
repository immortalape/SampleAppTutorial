package com.example.sampleapptutorial.network

import com.example.sampleapptutorial.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

        @GET("users/{user}")
        fun getUser(
            @Path("user") username: String
        ): Call<User>

}