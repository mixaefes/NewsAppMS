package com.example.newsapptask.model

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsList(
    @field:Json(name = "data") val data: List<NewsItem>
)

@JsonClass(generateAdapter = true)
data class NewsItem(
    @field:Json(name = "author")  val author: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "category") val category: String
)
