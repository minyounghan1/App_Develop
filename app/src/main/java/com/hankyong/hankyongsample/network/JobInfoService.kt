package com.hankyong.hankyongsample.network

import com.hankyong.hankyongsample.common.AppConstant
import com.hankyong.hankyongsample.extensions.empty
import com.hankyong.hankyongsample.model.JobInfoResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

//Todo '서울시 일자리플러스센터 채용 정보' 공공 api 요청의 인터페이스와 구현체. 참고용 이며,
// Hilt Module 에 의해서 ViewModel 로 전달되고, Retrofit 으로 통신함.
// 사용 하려는 공공 api 에 따라 GET, POST 등 다른 방법으로 다양한 인자를 전달 해야함.

interface JobInfoService {
    @GET("/${AppConstant.API_AUTH_KEY}/json/GetJobInfo/{startIdx}/{endIdx}/{eduCode}/{empTypeCode}/{workAddr}/{careerCode}")
    suspend fun getJobInfoList(
        @Path("startIdx") startIdx: Int,
        @Path("endIdx") endIdx: Int,
        @Path("eduCode") eduCode: String = String.empty(),
        @Path("empTypeCode") empTypeCode: String = String.empty(),
        @Path("workAddr") workAddr: String = String.empty(),
        @Path("careerCode") careerCode: String = String.empty(),
    ): BaseResponse<JobInfoResponse> //Todo 샘플은 필요에 의해 BaseResponse 가 사용되었음에 주의.
}

class JobInfoServiceImpl @Inject constructor(retrofit: Retrofit) : JobInfoService {
    private val api by lazy {
        retrofit.create(JobInfoService::class.java)
    }

    override suspend fun getJobInfoList(
        startIdx: Int,
        endIdx: Int,
        eduCode: String,
        empTypeCode: String,
        workAddr: String,
        careerCode: String
    ): BaseResponse<JobInfoResponse> {
        return api.getJobInfoList(startIdx, endIdx, eduCode, empTypeCode, workAddr, careerCode)
    }
}