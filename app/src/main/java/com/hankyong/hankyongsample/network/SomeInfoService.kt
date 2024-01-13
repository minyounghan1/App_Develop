package com.hankyong.hankyongsample.network

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface SomeInfoService {

    companion object {
        private const val REQUEST_GET_LIST_URL = "getCctvStnRoadWthr" //rest api url 예시..
    }

    @GET(REQUEST_GET_LIST_URL)
    suspend fun getSomeInfoList(
        @Query("ServiceKey", encoded = true) key: String,
        @Query("pageNo", encoded = true) pageNo: Int,
        @Query("numOfRows", encoded = true) numOfRows: Int,
        @Query("dataType", encoded = true) datatype: String,
        @Query("eqmtId", encoded = true) eqmtId: String,
        @Query("hhCode", encoded = true) hhCode: String
    ): BaseResponse
}

class SomeInfoServiceImpl @Inject constructor(retrofit: Retrofit) : SomeInfoService {
    private val api by lazy {
        retrofit.create(SomeInfoService::class.java)
    }

    override suspend fun getSomeInfoList(
        key: String,
        pageNo: Int,
        numOfRows: Int,
        datatype: String,
        eqmtId: String,
        hhCode: String
    ): BaseResponse {
        return api.getSomeInfoList(key, pageNo, numOfRows, datatype, eqmtId, hhCode)
    }
}