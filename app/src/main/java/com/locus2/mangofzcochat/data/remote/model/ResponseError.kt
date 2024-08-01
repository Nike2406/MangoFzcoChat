package com.locus2.mangofzcochat.data.remote.model
import com.google.gson.annotations.SerializedName


data class ResponseError(
    @SerializedName("detail")
    val detail: List<Detail>
)

data class Detail(
    @SerializedName("loc")
    val loc: List<String>,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("type")
    val type: String
)