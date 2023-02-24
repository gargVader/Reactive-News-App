package com.example.newsapp.data.model

data class Article(
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)