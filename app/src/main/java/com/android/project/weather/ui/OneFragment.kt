package com.android.project.weather.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.project.weather.R
import com.android.project.weather.api.RetrofitInterface
import com.android.project.weather.api.getRetrofit
import com.android.project.weather.data.Item
import com.android.project.weather.data.ResponseX
import com.android.project.weather.databinding.FragmentOneBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class OneFragment: Fragment() {
    lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)

        Log.d("OneFragment","프래그먼트에서 함수 호출")
        getWeatherInfo()

        return binding.root
    }

    private fun getWeatherInfo(){
        val retrofitService = getRetrofit().create(RetrofitInterface::class.java)
        Log.d("OneFragment", retrofitService.toString())

        //pageNo=1&numOfRows=10&dataType=JSON&dataCd=ASOS&dateCd=HR&startDt=20100101&startHh=01&endDt=20100601&endHh=01&stnIds=108
        retrofitService.getWeather2(
            "JSON",
            "ASOS",
            "HR",
            "20100101",
            "01",
            "20100601",
            "01",
            "108"
        )
            .enqueue(object : Callback<ResponseX>{
                override fun onResponse(call: Call<ResponseX>, response: Response<ResponseX>) {
                    Log.d("OneFragment", "레트로핏 성공" )

                    Log.d("OneFragment", response.isSuccessful().toString())
                    var itemList = response.body()?.response?.body?.items?.item
                    Log.d("OneFragement", ""+itemList?.size)
                    //if (itemList != null) {
                        itemList?.forEach{
                            it-> Log.d("OneFragment", it.toString())
                        }
                    //}
                }

                override fun onFailure(call: Call<ResponseX>, t: Throwable) {

                }

            })
//            .enqueue(object : Callback<com.android.project.weather.data.ResponseX>{
//                //응답 왔을 때
//                override fun onResponse(call: Call<com.android.project.weather.data.Response>, response: Response<com.android.project.weather.data.Response>
//                ) {
//                    Log.d("OneFragment", "레트로핏 성공" )
//
//                    Log.d("OneFragment", response.isSuccessful().toString())
//                    var itemList: List<Item> = response.body()?.response?.body?.items?.item as List<Item>
//                    Log.d("OneFragement", ""+itemList?.size)
//                    //if (itemList != null) {
//                        itemList.forEach{
//                            it-> Log.d("OneFragment", it.toString())
//                        }
//                    //}
//                }
//
//                //네트워크 연결자체의 실패
//                override fun onFailure(
//                    call: Call<com.android.project.weather.data.Response>, t: Throwable
//                ) {
//                    Log.d("OneFragment", "Fail: " + t.message)
//                }
//
//            })
    }
}