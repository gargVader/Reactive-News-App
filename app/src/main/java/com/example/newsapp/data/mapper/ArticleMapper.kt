package com.example.newsapp.data.mapper

import com.example.newsapp.data.model.ArticleResponse
import com.example.newsapp.data.model.ArticleEntity

fun ArticleEntity.toArticleResponse(): ArticleResponse {
    return ArticleResponse(
        source = source,
        title = title,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )
}

fun ArticleResponse.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        source = source,
        title = title,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt
    )
}