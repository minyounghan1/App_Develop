package com.hankyong.hankyongsample.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class SomeInfoResponse(
    @SerializedName("header")
    val header: HeaderData,
    @SerializedName("body")
    val body: BodyData,
)

data class HeaderData(
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMsg")
    val resultMsg: String,
)

@Parcelize
data class BodyData(
    @SerializedName("dataType")
    val dataType: String,
    @SerializedName("pageNo")
    val pageNo: Int,
    @SerializedName("numOfRows")
    val numOfRows: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("items")
    val item: ItemsData,
) : Parcelable

@Parcelize
data class ItemsData(
    @SerializedName("item")
    val items: List<ItemData>,
) : Parcelable

@Parcelize
data class ItemData(
    @SerializedName("baseDate")
    val baseDate: String,
    @SerializedName("baseTime")
    val baseTime: String,
    @SerializedName("weatherNm")
    val weatherNm: String,
) : Parcelable
