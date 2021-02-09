package com.example.myfruits.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("fruits")
    fun getData(): Call<List<MainModel>>
}
