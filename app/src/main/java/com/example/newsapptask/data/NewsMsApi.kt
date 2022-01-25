package com.example.newsapptask.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//   http://api.mediastack.com/v1/news?access_key=c140a0f1f3331748afd0d7a51a248b1b&limit=10
interface NewsMsApi {
    @GET("news?access_key=c140a0f1f3331748afd0d7a51a248b1b&limit=10")
    suspend fun getNewsList()
}

object NewsApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://api.mediastack.com/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    private val newsService = retrofit.create(NewsMsApi::class.java)
    suspend fun getNewsService() {
        //todo
    }

}