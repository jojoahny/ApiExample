package com.example.apiexample

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
        @GET("posts") // Replace "endpoint" with your actual endpoint
        fun getPosts():Call<PostResponse>
        @GET("comments") // Replace "endpoint" with your actual endpoint
        fun getComments():Call<PostComment>
}