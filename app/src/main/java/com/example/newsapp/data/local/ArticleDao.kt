package com.example.newsapp.data.local

import androidx.room.*
import com.example.newsapp.data.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articleentity")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Insert
    suspend fun insert(article: ArticleEntity): Long

    @Update
    suspend fun update(article: ArticleEntity)

    @Delete
    suspend fun delete(article: ArticleEntity)

    @Query("DELETE FROM articleentity")
    suspend fun deleteAll()
}