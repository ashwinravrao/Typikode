package com.ashwinrao.typikode.network.di

import com.ashwinrao.typikode.network.TypicodeService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitProvider {

    private val typicodeBaseUrl = "https://jsonplaceholder.typicode.com"

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(typicodeBaseUrl)
            .addConverterFactory(
                Json.asConverterFactory(
                    contentType = "application/json".toMediaType()
                )
            ).build()

    @Provides
    fun provideTypicodeService(retrofit: Retrofit): TypicodeService =
        retrofit.create(TypicodeService::class.java)

}
