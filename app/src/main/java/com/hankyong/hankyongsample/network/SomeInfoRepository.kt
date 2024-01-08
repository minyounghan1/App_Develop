package com.hankyong.hankyongsample.network

import com.hankyong.hankyongsample.model.SomeInfoRequest
import com.hankyong.hankyongsample.model.SomeInfoResponse
import retrofit2.Response
import retrofit2.http.Query
import timber.log.Timber
import javax.inject.Inject

interface SomeInfoRepository {

    suspend fun getSomeInfoList(
        key: String,
        pageNo: Int,
        numOfRows: Int,
        datatype: String,
        eqmtId: String,
        hhCode: String
    ): Result<SomeInfoResponse, Exception>

}

class SomeInfoRepositoryImpl @Inject constructor(
    private val service: SomeInfoService,
) : SomeInfoRepository {
    override suspend fun getSomeInfoList(
        key: String,
        pageNo: Int,
        numOfRows: Int,
        datatype: String,
        eqmtId: String,
        hhCode: String
    ): Result<SomeInfoResponse, Exception> {
        return request(
            service.getSomeInfoList(
                key, pageNo, numOfRows, datatype, eqmtId, hhCode
            )
        )
    }

    private fun request(
        response: BaseResponse,
    ): Result<SomeInfoResponse, Exception> {
        return try {
            val resultCode = response.response.header.resultCode
            if (resultCode == "00") {
                Result.Success(response.response)
            } else {
                Result.Error(Exception("Fail to retrieve data."))
            }
            //Todo resultCode 에 따른 처리를 UI 에서 하려면, 위 코드 예시 처럼
            // resultCode == "00" 으로 사용하지 말고,
            // if (response.response != null) 로 사용 하세요..
        } catch (exception: Exception) {
            Timber.e(exception.toString())
            Result.Error(exception)
        }
    }
}