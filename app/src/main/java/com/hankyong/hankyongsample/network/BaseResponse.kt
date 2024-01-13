package com.hankyong.hankyongsample.network

import com.google.gson.annotations.SerializedName
import com.hankyong.hankyongsample.model.SomeInfoResponse

data class BaseResponse(
    @SerializedName("response")
    val response: SomeInfoResponse
)