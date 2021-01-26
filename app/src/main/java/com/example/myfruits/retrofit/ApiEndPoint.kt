package com.example.myfruits.retrofit

import com.example.myfruits.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("fruits")
    fun getData(): Call<List<MainModel>>
}
