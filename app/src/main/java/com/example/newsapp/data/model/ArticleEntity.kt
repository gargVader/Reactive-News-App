package com.example.newsapp.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @Embedded
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String
)