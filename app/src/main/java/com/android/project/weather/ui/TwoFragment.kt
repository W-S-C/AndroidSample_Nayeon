package com.android.project.weather.ui

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.project.weather.R
import com.android.project.weather.databinding.FragmentTwoBinding

class TwoFragment: Fragment() {
    lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater, container, false)

        //하단 프래그먼트 초기설정
        childFragmentManager.beginTransaction()
            .replace(R.id.frame_search, SearchFragment())
            .commitAllowingStateLoss()

        //키워드 검색 후 엔터눌렀을 때 하단 프래그먼트 변경
        binding.etSearch.setOnKeyListener{ _, keyCode, event ->
            if((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                //검색 키워드 번들로 전달
                Log.d("SearchFragment", "엔터 전" + binding.etSearch.text.toString())

                var bundle:Bundle = Bundle(1)
                bundle.putString("keyword", binding.etSearch.text.toString())

                val srf = SearchResultFragment()
                srf.arguments = bundle

                childFragmentManager.beginTransaction()
                    .replace(R.id.frame_search, srf)
                    .commitAllowingStateLoss()

                true
            }else{

                false
            }
        }

        //취소 터치 시, 원래 프래그먼트로
        binding.btnCancel.setOnClickListener{
            childFragmentManager.beginTransaction()
                .replace(R.id.frame_search, SearchFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }
}