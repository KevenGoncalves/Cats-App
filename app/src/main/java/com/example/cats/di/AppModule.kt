package com.example.cats.di

import com.example.cats.api.CatService
import com.example.cats.api.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }

    @Provides
    @Singleton
    fun provideCatService(retrofitClient: RetrofitClient): CatService {
        return retrofitClient.createService(CatService::class.java)
    }
}