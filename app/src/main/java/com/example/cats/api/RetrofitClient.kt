package com.example.cats.api

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class RetrofitClient {

    private val _baseUrl = "https://cat-fact.herokuapp.com/"

    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val _client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    private val _jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    private val retro: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(_baseUrl)
            .client(_client)
            .addConverterFactory(_jsonParser.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    fun <T> createService(service: Class<T>): T {
        return retro.create(service)
    }
}