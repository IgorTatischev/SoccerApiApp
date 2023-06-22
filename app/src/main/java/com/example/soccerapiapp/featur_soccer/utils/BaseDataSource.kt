package com.example.soccerapiapp.featur_soccer.utils

import retrofit2.Response

abstract class BaseDataSource {
    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): Resource<T> {
        try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                } ?: return errorMessage("Body is empty")
            } else {
                return errorMessage("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            return errorMessage(e.message.toString())
        }
    }

    private fun <T> errorMessage(e: String): Resource.Error<T> =
        Resource.Error(data = null, message = "Api call failed: $e")
}