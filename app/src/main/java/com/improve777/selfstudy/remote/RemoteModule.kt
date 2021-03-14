package com.improve777.selfstudy.remote

import com.google.gson.GsonBuilder
import com.improve777.common.remote.createLoggingInterceptor
import com.improve777.common.remote.createRetrofit
import com.improve777.selfstudy.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ) = createRetrofit(
        "https://www.googleapis.com/youtube/v3/",
        okHttpClient,
        converterFactory,
    )

    @Provides
    fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(createLoggingInterceptor(BuildConfig.DEBUG))
        .build()

    @Provides
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create(
        GsonBuilder().setLenient().create()
    )
}