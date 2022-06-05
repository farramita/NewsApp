package com.example.mynewsapp.data.api

import androidx.viewbinding.BuildConfig
import com.example.mynewsapp.BuildConfig.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country:String = BuildConfig.COUNTRY,
        @Query("apiKey") api:String = BuildConfig.API_KEY
    ) : Response<NewsResponse>
}