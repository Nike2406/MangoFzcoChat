package com.locus2.mangofzcochat.data.remote.model.register
import com.google.gson.annotations.SerializedName


data class RegisterResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user_id")
    val userId: Int,
)