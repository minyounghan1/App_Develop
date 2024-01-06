package com.hankyong.hankyongsample.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//Todo 공공 api 응답에 사용되는 데이터 클래스.
// 아래 코드들은 '서울시 일자리플러스센터 채용 정보' api 응답.
// 사용하려는 공공 api 의 응답 명세에 맞춰 수정하여 사용.
// SampleApiInfo 파일의 api 사이트 참조.

/**
 * 일자리 정보 응답 데이터.
 */
data class JobInfoResponse(
    /**
     * 요청 조건에 부합 하는 일자리 정보 총 수.
     */
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    /**
     * 요청에 대한 상태 결과.
     */
    @SerializedName("RESULT")
    val requestResult: DataResult,
    /**
     * 일자리 정보 리스트.
     */
    @SerializedName("row")
    val jobInfoDetailList: List<JobInfoDetail>,
)

/**
 * 응답 결과(상태).
 */
data class DataResult(
    @SerializedName("CODE")
    val resultCode: String,
    @SerializedName("MESSAGE")
    val resultMessage: String,
)

/**
 * 일자리 정보 상세.
 */
@Parcelize
data class JobInfoDetail(
    /**
     * JO_REQST_NO : 구인신청번호
     */
    @SerializedName("JO_REQST_NO")
    val jobRequestNumber: String,
    /**
     * JO_REGIST_NO : 구인등록번호
     */
    @SerializedName("JO_REGIST_NO")
    val jobRegisterNumber: String,
    /**
     * CMPNY_NM : 기업명칭
     */
    @SerializedName("CMPNY_NM")
    val companyName: String,
    /**
     * BSNS_SUMRY_CN : 사업요약내용
     */
    @SerializedName("BSNS_SUMRY_CN")
    val bsnsSumryCn: String,
    /**
     * RCRIT_JSSFC_CMMN_CODE_SE : 모집직종코드
     */
    @SerializedName("RCRIT_JSSFC_CMMN_CODE_SE")
    val rcritJssfcCmmnCodeSe: String,
    /**
     * JOBCODE_NM : 모집직종코드명
     */
    @SerializedName("JOBCODE_NM")
    val jobCodeNm: String,
    /**
     * RCRIT_NMPR_CO : 모집인원수
     */
    @SerializedName("RCRIT_NMPR_CO")
    val rcritNmprCo: String,
    /**
     * ACDMCR_CMMN_CODE_SE : 학력코드 (J00108:전문대학, J00104:중학교, J00106:고등학교, J00102:초등학교, J00110:대학_대학교, J00100:관계없음, J00114:박사과정)
     */
    @SerializedName("ACDMCR_CMMN_CODE_SE")
    val acdmcrCmmnCodeSe: String,
    /**
     * ACDMCR_NM : 학력코드명
     */
    @SerializedName("ACDMCR_NM")
    val acdmcrNm: String,
    /**
     * EMPLYM_STLE_CMMN_CODE_SE : 고용형태코드 (J01102:계약직, J01105:상용직(시간제), J01101:상용직, J01103:계약직(시간제))
     */
    @SerializedName("EMPLYM_STLE_CMMN_CODE_SE")
    val emplymStleCmmnCodeSe: String,
    /**
     * EMPLYM_STLE_CMMN_MM : 고용형태코드명
     */
    @SerializedName("EMPLYM_STLE_CMMN_MM")
    val emplymStleCmmnMm: String,
    /**
     * WORK_PARAR_BASS_ADRES_CN : 근무예정지 주소
     */
    @SerializedName("WORK_PARAR_BASS_ADRES_CN")
    val workPararBassAdresCn: String,
    /**
     * SUBWAY_NM : 인접전철역
     */
    @SerializedName("SUBWAY_NM")
    val subwayNm: String,
    /**
     * DTY_CN : 직무내용
     */
    @SerializedName("DTY_CN")
    val dtyCn: String,
    /**
     * CAREER_CND_CMMN_CODE_SE : 경력조건코드 (J01301: 신입, J01302: 경력, J01300: 무관)
     */
    @SerializedName("CAREER_CND_CMMN_CODE_SE")
    val careerCndCmmnCodeSe: String,
    /**
     * CAREER_CND_NM : 경력조건코드명
     */
    @SerializedName("CAREER_CND_NM")
    val careerCndNm: String,
    /**
     * HOPE_WAGE : 급여조건
     */
    @SerializedName("HOPE_WAGE")
    val hopeWage: String,
    /**
     * RET_GRANTS_NM : 퇴직금구분
     */
    @SerializedName("RET_GRANTS_NM")
    val retGrantsNm: String,
    /**
     * WORK_TIME_NM : 근무시간
     */
    @SerializedName("WORK_TIME_NM")
    val workTimeNm: String,
    /**
     * WORK_TM_NM : 근무형태
     */
    @SerializedName("WORK_TM_NM")
    val workTmNm: String,
    /**
     * HOLIDAY_NM : 공휴일
     */
    @SerializedName("HOLIDAY_NM")
    val holidayNm: String,
    /**
     * WEEK_WORK_HR : 주당근무시간
     */
    @SerializedName("WEEK_WORK_HR")
    val weekWorkHr: String,
    /**
     * JO_FEINSR_SBSCRB_NM : 4대보험
     */
    @SerializedName("JO_FEINSR_SBSCRB_NM")
    val joFeinsrSbscrbNm: String,
    /**
     * RCEPT_CLOS_NM : 마감일
     */
    @SerializedName("RCEPT_CLOS_NM")
    val rceptClosNm: String,
    /**
     * RCEPT_MTH_IEM_NM : 전형장소
     */
    @SerializedName("RCEPT_MTH_IEM_NM")
    val rceptMthIemNm: String,
    /**
     * MODEL_MTH_NM : 전형방법
     */
    @SerializedName("MODEL_MTH_NM")
    val modelMthNm: String,
    /**
     * RCEPT_MTH_NM : 접수방법
     */
    @SerializedName("RCEPT_MTH_NM")
    val rceptMthNm: String,
    /**
     * PRESENTN_PAPERS_NM : 제출서류
     */
    @SerializedName("PRESENTN_PAPERS_NM")
    val presentnPapersNm: String,
    /**
     * MNGR_NM : 담당 상담사명
     */
    @SerializedName("MNGR_NM")
    val mngrNm: String,
    /**
     * MNGR_PHON_NO : 담당 상담사 전화번호
     */
    @SerializedName("MNGR_PHON_NO")
    val mngrPhonNo: String,
    /**
     * MNGR_INSTT_NM : 담당 상담사 소속기관명
     */
    @SerializedName("MNGR_INSTT_NM")
    val mngrInsttNm: String,
    /**
     * BASS_ADRES_CN : 기업 주소
     */
    @SerializedName("BASS_ADRES_CN")
    val bassAdrsCn: String,
    /**
     * JO_SJ : 구인제목
     */
    @SerializedName("JO_SJ")
    val joSj: String,
    /**
     * JO_REG_DT : 등록일
     */
    @SerializedName("JO_REG_DT")
    val joRegDt: String,
    /**
     * GUI_LN : 모집요강
     */
    @SerializedName("GUI_LN")
    val guiLn: String,
) : Parcelable
