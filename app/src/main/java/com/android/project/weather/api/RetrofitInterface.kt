package com.android.project.weather.api

import com.android.project.weather.data.Response
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("getWthrDataList?serviceKey=QbdYIL1WhHyExQs4Fc%2FoyGefFsCZdxRJ1Xs5o9EJO4jUipQ4wNB39gqavienpXYTWaHdvP%2BggZmvmA5b2GBFDQ%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&dataCd=ASOS&dateCd=HR&startDt=20100101&startHh=01&endDt=20100601&endHh=01&stnIds=108")
    fun getWeather(): Call<Response>
}