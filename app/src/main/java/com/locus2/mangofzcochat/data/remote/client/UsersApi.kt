package com.locus2.mangofzcochat.data.remote.client

import com.locus2.mangofzcochat.data.remote.model.register.RegisterRequest
import com.locus2.mangofzcochat.data.remote.model.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.POST

interface UsersApi {

    @POST("send-auth-code")
    suspend fun sendAuthCode(phoneNumber: String): Response<Boolean>

    @POST("register")
    suspend fun register(registerRequest: RegisterRequest): Response<RegisterResponse>
}