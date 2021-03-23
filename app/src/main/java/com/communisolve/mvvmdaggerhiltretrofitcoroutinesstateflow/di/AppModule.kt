package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.di

import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    fun providesbaseurl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideAPIservice(url:String): ApiService = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)
}