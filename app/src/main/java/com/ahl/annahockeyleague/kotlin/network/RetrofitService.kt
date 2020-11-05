package com.ahl.annahockeyleague.kotlin.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://young-coast-02878.herokuapp.com"

    private val retrofitInstance = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
//        addCallAdapterFactory(CoroutineCallAdapterFactory())
    }.build()

    val getInstance: ApiService = retrofitInstance.create(ApiService::class.java)

}