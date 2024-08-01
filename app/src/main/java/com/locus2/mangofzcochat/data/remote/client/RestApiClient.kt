package com.locus2.mangofzcochat.data.remote.client

import com.locus2.mangofzcochat.data.remote.utils.ApiResponse
import com.locus2.mangofzcochat.data.remote.utils.ApiResponse.Failed.Companion.parseResponseError
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApiClient @Inject constructor(
    private val api: MangoFzcoChatApi,
) {

    companion object {
        val <T> Response<T>.data: T
            get() = body() ?: throw IllegalStateException()
    }

    private suspend inline fun <T : Any, reified E : Any> fetch(
        crossinline apiServiceRequest: ApiServiceRequest<T>
    ): ApiResponse<T, E> {
        return runCatching {
            apiServiceRequest(api)
        }.fold(
            onSuccess = { response ->
                when {
                    response.isSuccessful -> ApiResponse.Success(data = response.data)
                    else -> response.parseResponseError()
                }
            },
            onFailure = {
                ApiResponse.Failed(null)
            }
        )
    }
}

typealias ApiServiceRequest<T> = suspend MangoFzcoChatApi.() -> Response<T>
