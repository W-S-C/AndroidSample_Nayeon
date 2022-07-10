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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

    private fun getWeatherByCoroutine(){
        GlobalScope.launch {

        }
    }

    private fun getWeatherInfo(){
        val retrofitService = getRetrofit().create(RetrofitInterface::class.java)
        Log.d("OneFragment", retrofitService.toString())

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
    }
}