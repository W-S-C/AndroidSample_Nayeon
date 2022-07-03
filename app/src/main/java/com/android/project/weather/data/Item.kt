package com.android.project.weather.data

data class Item(
    var tm: String, //시간(2010-01-01 10)
    var rnum: Int,  //목록 순서
    var stnId: Int, //기상관측 지점 번호
    var ta: Double, //기온(ºC)
    var rn: Double, //강수량(mm)
    var hm: Double, //습도(%)
)
