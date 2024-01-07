package com.hankyong.hankyongsample.model

import com.hankyong.hankyongsample.common.AppConstant
import retrofit2.http.Query

data class SomeInfoRequest(
    @Query("ServiceKey")
    val ServiceKey: String = AppConstant.API_AUTH_KEY, //앱에서 사용 하려는 변수명.
    @Query("pageNo")
    val pageNo: Int,
    @Query("numOfRows")
    val numOfRows: Int,
    @Query("dataType")
    val dataType: String,
    @Query("eqmtId")
    val eqmtId: String,
    @Query("hhCode")
    val hhCode: String
)
