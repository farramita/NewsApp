package com.example.mynewsapp.di

import com.example.mynewsapp.data.api.NewsAPIService
import com.example.mynewsapp.repository.MainRepository
import com.example.mynewsapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsAPIService(): NewsAPIService = Retrofit.Builder().
    addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constant.BASE_URL).build()
        .create(NewsAPIService::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(newsAPIService: NewsAPIService) = MainRepository(newsAPIService)
}