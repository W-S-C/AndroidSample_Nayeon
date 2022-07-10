package com.android.project.weather.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.project.weather.databinding.FragmentSearchResultBinding


class SearchResultFragment: Fragment() {
    lateinit var binding:FragmentSearchResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchResultBinding.inflate(inflater, container, false)

        var bundle = arguments
        Log.d("SearchFragment", "번들값: " + bundle?.getString("keyword"))
        if(bundle != null)
            binding.tvKeyword.text = "'" + bundle.getString("keyword") + "'"

        return binding.root
    }
}