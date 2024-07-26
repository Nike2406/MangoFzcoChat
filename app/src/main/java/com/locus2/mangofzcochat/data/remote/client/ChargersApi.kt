package com.locus2.mangofzcochat.data.remote.client

import retrofit2.Response
import retrofit2.http.POST

interface AuthorizationApi {

    @POST("some_chargers")
    suspend fun sendAuthCode(phoneNumber: String): Response<Boolean>
}