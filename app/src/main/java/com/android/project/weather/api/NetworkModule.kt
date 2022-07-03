package com.android.project.weather.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://apis.data.go.kr/1360000/AsosHourlyInfoService/"

var gson = GsonBuilder().setLenient().create()

//레트로핏 객체 반환
fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    return retrofit
}