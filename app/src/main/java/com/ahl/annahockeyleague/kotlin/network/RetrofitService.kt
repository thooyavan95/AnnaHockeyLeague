package com.ahl.annahockeyleague.kotlin.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://young-coast-02878.herokuapp.com"

    private val retrofitInstance = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }.build()

    val getInstance: ApiService = retrofitInstance.create(ApiService::class.java)

}