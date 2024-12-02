package com.example.cats.api

import javax.inject.Inject

class CatRepository @Inject constructor(
    private val _service: CatService
) {

    suspend fun getCatFacts(): ApiResponse<List<Cat>> {
        try {
            val response = _service.getCatFacts()
            if (!response.isSuccessful) throw Exception("An error occurred")

            val body = response.body() ?: throw Exception("An error occurred")

            return ApiResponse.Success(body)

        } catch (e: Exception) {
            return ApiResponse.Error(e.message ?: "An error occurred")
        }
    }
}