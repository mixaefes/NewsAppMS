package com.example.newsapptask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteNews(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String? = null,
    val description: String? = null,
    var category: String? = null,
    var image: String? = null
)