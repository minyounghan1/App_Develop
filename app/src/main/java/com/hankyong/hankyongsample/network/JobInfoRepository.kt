package com.hankyong.hankyongsample.network

import com.hankyong.hankyongsample.model.JobInfoResponse
import timber.log.Timber
import javax.inject.Inject

//Todo '서울시 일자리플러스센터 채용 정보' 공공 api 요청의 인터페이스와 구현체. 참고용 이며,

interface JobInfoRepository {
    suspend fun getJobInfoList(
        startIdx: Int,
        endIdx: Int,
        eduCode: String,
        empTypeCode: String,
        workAddr: String,
        careerCode: String
    ): Result<JobInfoResponse, Exception>
}

class JobInfoRepositoryImpl @Inject constructor(
    private val service: JobInfoService,
) : JobInfoRepository {
    override suspend fun getJobInfoList(
        startIdx: Int,
        endIdx: Int,
        eduCode: String,
        empTypeCode: String,
        workAddr: String,
        careerCode: String
    ): Result<JobInfoResponse, Exception> {
        return request(
            service.getJobInfoList(startIdx, endIdx, eduCode, empTypeCode, workAddr, careerCode),
        ) { it }
    }

    private fun <T, R> request(
        response: BaseResponse<T>,
        transform: (T) -> R,
    ): Result<R, Exception> {
        return try {
            if (response.info != null) {
                Result.Success(transform(response.info))
            } else {
                Result.Error(Exception("Fail to retrieve data."))
            }
        } catch (exception: Exception) {
            Timber.e(exception.toString())
            Result.Error(exception)
        }
    }
}