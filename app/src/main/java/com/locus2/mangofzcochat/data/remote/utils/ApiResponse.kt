package com.locus2.mangofzcochat.data.remote.utils

import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

sealed class ApiResponse<out T : Any, out E : Any> {

    data class Success<T : Any>(
        val data: T?,
    ) : ApiResponse<T, Nothing>()

    data class Failed<E : Any>(
        val error: E?,
    ) : ApiResponse<Nothing, E>() {

        companion object {
            inline fun <reified E : Any> Response<*>.parseResponseError(): Failed<E> {
                return try {
                    val errorBody = this.errorBody()
                    val errorJson = errorBody?.string()

                    val gson = Gson()

                    val error = gson.fromJson(errorJson, E::class.java)
                    Timber.tag("API_RESPONSE").e("error: $error")

                    Failed(error)
                } catch (e: Exception) {
                    Timber.tag("API_RESPONSE").e("parseResponseError: $e")
                    return Failed(null)
                }
            }

            inline fun <R : Any, E : Any, reified S : Any, reified F : Any> ApiResponse<R, E>.map(
                transform: (R) -> S?,
                transformError: (E) -> F?,
            ): ApiResponse<S, F> {
                return when (this) {
                    is Success<R> -> Success(data?.let { transform(it) })
                    is Failed<E> -> Failed(error?.let { transformError(it) })
                }
            }
        }
    }
}
