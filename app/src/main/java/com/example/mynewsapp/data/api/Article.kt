package com.example.mynewsapp.data.api

import com.google.gson.annotations.SerializedName

data class Article(
    @field:SerializedName("source")
    val source: SourceObject,
    @field:SerializedName("author")
    val author : String?,
    @field:SerializedName("title")
    val title : String?,
    @field:SerializedName("description")
    val description : String,
    @field:SerializedName("url")
    val url : String,
    @field:SerializedName("urlToImage")
    val urlImg : String,
    @field:SerializedName("publishedAt")
    val publishedTime : String,
    @field:SerializedName("content")
    val content : String?,
)
