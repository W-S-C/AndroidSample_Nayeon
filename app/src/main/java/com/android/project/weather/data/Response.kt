package com.android.project.weather.data

data class Response(
    val header: Header,
    val body: Body
)

data class Header(
    val resultCode: Int,
    val resultMsg: String
)

