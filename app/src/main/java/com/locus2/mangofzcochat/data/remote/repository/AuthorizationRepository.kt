package com.locus2.mangofzcochat.data.remote.repository

import com.locus2.mangofzcochat.data.remote.client.UsersApi
import com.locus2.mangofzcochat.data.remote.model.register.RegisterRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(
    private val api: UsersApi,
) {

    suspend fun register(
        name: String,
        phone: String,
        username: String,
    ): Flow<> = flow {
        api.register(RegisterRequest(
            name = name,
            phone = phone,
            username = username,
        ))
    }
}