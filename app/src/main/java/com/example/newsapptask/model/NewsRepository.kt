package com.example.newsapptask.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDao: Dao) {
    val allFavoriteNews : LiveData<List<FavoriteNews>> = newsDao.getAllItems()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertNews(favoriteNews: FavoriteNews) {
        newsDao.insertNews(favoriteNews)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteNews(favoriteNews: FavoriteNews) {
        newsDao.delNews(favoriteNews)
    }
}