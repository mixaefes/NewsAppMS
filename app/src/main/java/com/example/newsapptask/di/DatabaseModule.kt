package com.example.newsapptask.di

import android.content.Context
import androidx.room.Room
import com.example.newsapptask.Constants
import com.example.newsapptask.data.FavoriteNewsDatabase
import com.example.newsapptask.model.Dao
import com.example.newsapptask.model.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideNewsDao(newsDatabase: FavoriteNewsDatabase): Dao {
        return newsDatabase.newsDao()
    }
    @Provides
    @Singleton
    fun providePurchaseDatabase(@ApplicationContext appContext: Context):FavoriteNewsDatabase{
        return Room.databaseBuilder(
            appContext,
            FavoriteNewsDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }
}