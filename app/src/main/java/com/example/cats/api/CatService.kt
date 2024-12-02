package com.example.cats.api

import retrofit2.Response
import retrofit2.http.GET

interface CatService {

    @GET("facts/random?amount=10")
    suspend fun getCatFacts(): Response<List<Cat>>

}