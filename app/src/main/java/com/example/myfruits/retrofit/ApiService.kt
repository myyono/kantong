package com.example.myfruits.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var BASE_URL:String ="http://api.skydu.cloud:8000/"
    val endpoint: ApiEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiEndPoint::class.java)

        }
}
