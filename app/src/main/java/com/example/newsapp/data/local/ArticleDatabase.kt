package com.example.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.data.model.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
)
abstract class ArticleDatabase : RoomDatabase() {
    abstract val articleDao : ArticleDao
}