package com.example.newsapp.data.model

data class NewsApiResponse(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>
)