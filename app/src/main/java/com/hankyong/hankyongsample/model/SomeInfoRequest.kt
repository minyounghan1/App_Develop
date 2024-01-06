package com.hankyong.hankyongsample.model

import com.google.gson.annotations.SerializedName
import com.hankyong.hankyongsample.common.AppConstant

//Todo 사용하려는 공공 api 에 맞춰 수정하여 사용.
// JobInfoRequest.kt 파일을 참고.
data class SomeInfoRequest(

    @SerializedName("ServiceKey") //api 명세에 정의된 파라메터 명.
    val ServiceKey: String = AppConstant.API_AUTH_KEY, //앱에서 사용 하려는 변수명.

    val pageNo: Int,
    val numOfRows: Int,
    val dataType: String,
    val eqmtId: String,
    val hhCode: String
    //요청 변수 추가...
)
