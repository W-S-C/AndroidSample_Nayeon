package com.android.project.weather.data

data class Body(
    val dataType: String,
    val items: ArrayList<Item>,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)
