package com.example.newsapptask.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapptask.Constants
import com.example.newsapptask.model.Dao
import com.example.newsapptask.model.FavoriteNews
import com.example.newsapptask.model.NewsItem

@Database(entities = [FavoriteNews::class], version = 1, exportSchema = false)
public abstract class FavoriteNewsDatabase : RoomDatabase() {
    abstract fun newsDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteNewsDatabase? = null
        fun getDataBase(
            context: Context
        ): FavoriteNewsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    FavoriteNewsDatabase::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}