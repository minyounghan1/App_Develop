package com.hankyong.hankyongsample.network

import com.hankyong.hankyongsample.model.SomeInfoRequest
import com.hankyong.hankyongsample.model.SomeInfoResponse
import retrofit2.Response
import retrofit2.http.Query
import timber.log.Timber
import javax.inject.Inject

//Todo 사용하려는 공공 api 에 맞춰 수정하여 사용.
interface SomeInfoRepository {

    suspend fun getSomeInfoList( key: String,
                                pageNo: Int,
                                numOfRows: Int,
                                datatype: String,
                                eqmtId: String,
                                hhCode: String ): Result<SomeInfoResponse, Exception>

}

class SomeInfoRepositoryImpl @Inject constructor(
    private val service: SomeInfoService,
): SomeInfoRepository {
    override suspend fun getSomeInfoList( key: String,
                                         pageNo: Int,
                                         numOfRows: Int,
                                         datatype: String,
                                         eqmtId: String,
                                         hhCode: String ): Result<SomeInfoResponse, Exception> {
        return request(
            service.getSomeInfoList(key,pageNo,numOfRows,datatype,eqmtId,hhCode
            )
        )
    }

    //Todo 요청 응답에 대한 전처리. 데이터의 형태와 처리 방식에 따라 수정이 필요함...
    private fun request(
        response: BaseResponse,
//        transform: (T) -> R,
    ): Result<SomeInfoResponse, Exception> {
        return try {
            val resultCode = response.response.header.resultCode
            if (resultCode == "00") {
                Result.Success(response.response)
            } else {
                Result.Error(Exception("Fail to retrieve data."))
            }
        } catch (exception: Exception) {
            Timber.e(exception.toString())
            Result.Error(exception)
        }
    }
}