package com.android.project.weather.api

import com.android.project.weather.data.Response
import com.android.project.weather.data.ResponseX
import org.intellij.lang.annotations.Pattern
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RetrofitInterface {
    @GET("getWthrDataList?serviceKey=QbdYIL1WhHyExQs4Fc%2FoyGefFsCZdxRJ1Xs5o9EJO4jUipQ4wNB39gqavienpXYTWaHdvP%2BggZmvmA5b2GBFDQ%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&dataCd=ASOS&dateCd=HR&startDt=20100101&startHh=01&endDt=20100601&endHh=01&stnIds=108")
    fun getWeather(): Call<ResponseX>

    /*
                10,
            1,
            "JSON",
            "HR",
            "ASOS",
            "20100101",
            "01",
            "20100601",
            "01",
            "108"
     */

    @GET("getWthrDataList?serviceKey=QbdYIL1WhHyExQs4Fc%2FoyGefFsCZdxRJ1Xs5o9EJO4jUipQ4wNB39gqavienpXYTWaHdvP%2BggZmvmA5b2GBFDQ%3D%3D&pageNo=1&numOfRows=10")
    fun getWeather2(
        @Query("dataType") dataType: String,    //응답자료 형식
        @Query("dataCd") dataCd: String,    //
        @Query("dateCd") dateCd: String,    //날짜 코드
        @Query("startDt") startDt: String, //시작일
        @Query("startHh") startHh: String, //시작시
        @Query("endDt") endDt: String, //종료시
        @Query("endHh") endHh: String,  //조회기간 종료 시
        @Query("stnIds") stnIds: String //종관기상관측 지점 번호
    ): Call<ResponseX>
}