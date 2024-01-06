package com.hankyong.hankyongsample.network

import com.hankyong.hankyongsample.model.SomeInfoRequest
import com.hankyong.hankyongsample.model.SomeInfoResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject

//Todo 사용하려는 공공 api 에 맞춰 수정하여 사용.
// JobInfoService.kt 파일을 참고.
// JobInfoService 와 달리 POST 로 요청하며, SomeInfoRequest 객체를 사용함에 주의.
interface SomeInfoService {

    companion object {
        private const val REQUEST_GET_LIST_URL = "getCctvStnRoadWthr" //rest api url 예시..
    }

//    @GET(REQUEST_GET_LIST_URL)
//    suspend fun getSomeInfoList(
//        @Body request: SomeInfoRequest,
//    ): Response<SomeInfoResponse>

    @GET(REQUEST_GET_LIST_URL)
    suspend fun getSomeInfoList(
        @Query("ServiceKey") key: String,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("datatype") datatype: String,
        @Query("eqmtId") eqmtId: String,
        @Query("hhCode") hhCode: String
    ): Response<SomeInfoResponse>
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
    ): Response<SomeInfoResponse> {
        return api.getSomeInfoList(key, pageNo, numOfRows, datatype, eqmtId, hhCode)
    }
}