package com.example.newsapptask.data

import com.example.newsapptask.model.NewsList
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


//   http://api.mediastack.com/v1/news?access_key=c140a0f1f3331748afd0d7a51a248b1b&limit=10&categories=business
interface NewsMsApi {
    @GET("news?access_key=c140a0f1f3331748afd0d7a51a248b1b")
    suspend fun getNewsList(
        @Query("categories") categoryId : String
    ): NewsList
}

object NewsApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://api.mediastack.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val newsService = retrofit.create(NewsMsApi::class.java)
    suspend fun getNewsService(categoryId : String): NewsList {
        return withContext(Dispatchers.IO) {
            newsService.getNewsList(categoryId)
        }
    }
}