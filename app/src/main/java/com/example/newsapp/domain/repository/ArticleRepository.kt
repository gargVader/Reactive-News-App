package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.ArticleEntity
import com.example.newsapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getAllArticles(): Flow<Resource<List<ArticleEntity>>>

    fun getSavedArticles(): Flow<List<ArticleEntity>>

    suspend fun insert(article: ArticleEntity): Long

    suspend fun delete(id: Long)

    suspend fun deleteAll()
}