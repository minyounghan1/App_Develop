package com.hankyong.hankyongsample.model

import com.google.gson.annotations.SerializedName
import com.hankyong.hankyongsample.common.AppConstant
import com.hankyong.hankyongsample.extensions.empty


//Todo 공공 api 요청 시 사용되는 데이터 클래스.
// 아래 코드들은 '서울시 일자리플러스센터 채용 정보' api 요청을 위해 작성되었으나, 해당 공공 api 에서는 요청 방식이 달라 사용은 하지 않음.
// api 요청 데이터 클래스의 예시로 참고하고, 사용하려는 공공 api 에서 사용이 가능하다면 api 명세에 맞춰 수정하여 사용할 것.
// SampleApiInfo 파일의 api 사이트 참조.

/**
 * 일자리 정보 요청 인자.
 */
data class JobInfoRequest(
    /**
     * KEY : String(필수), 인증키, OpenAPI 에서 발급된 인증키.
     */
    @SerializedName("KEY")
    val authKey: String = AppConstant.API_AUTH_KEY,
    /**
     * TYPE : String(필수), 요청파일타입,	xml : xml, xml파일 : xmlf, 엑셀파일 : xls, json파일 : json.
     */
    @SerializedName("TYPE")
    val responseType: String = "json",
    /**
     * SERVICE :	String(필수), 서비스명, GetJobInfo.
     */
    @SerializedName("SERVICE")
    val serviceName: String = "GetJobInfo",
    /**
     * START_INDEX : INTEGER(필수), 요청시작위치, 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호).
     */
    @SerializedName("START_INDEX")
    val startIndex: Int = 0,
    /**
     * END_INDEX : INTEGER(필수), 요청종료위치, 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호).
     */
    @SerializedName("END_INDEX")
    val endIndex: Int = startIndex + 5,
    /**
     * ACDMCR_CMMN_CODE_SE : STRING(선택), 학력코드.
     */
    @SerializedName("ACDMCR_CMMN_CODE_SE")
    val educationCode: String = String.empty(),
    /**
     * EMPLYM_STLE_CMMN_CODE_SE : STRING(선택), 고용형태코드.
     */
    @SerializedName("EMPLYM_STLE_CMMN_CODE_SE")
    val employTypeCode: String = String.empty(),
    /**
     * WORK_PARAR_BASS_ADRES_CN : STRING(선택), 근무예정지 주소.
     */
    @SerializedName("WORK_PARAR_BASS_ADRES_CN")
    val workPlaceAddress: String = String.empty(),
    /**
     * CAREER_CND_CMMN_CODE_SE : STRING(선택), 경력조건코드.
     */
    @SerializedName("CAREER_CND_CMMN_CODE_SE")
    val careerConditionCode: String = String.empty(),
)
