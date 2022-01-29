package com.example.newsapptask.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM favoriteNews")
    fun getAllItems() : LiveData<List<FavoriteNews>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: FavoriteNews)

    @Delete
    suspend fun delNews(news: FavoriteNews)

}