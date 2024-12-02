package com.example.cats.api

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error<out T>(val message: String) : ApiResponse<T>()
}