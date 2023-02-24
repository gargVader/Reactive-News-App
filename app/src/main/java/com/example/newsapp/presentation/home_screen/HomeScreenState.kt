package com.example.newsapp.presentation.home_screen

import com.example.newsapp.data.model.ArticleEntity

data class HomeScreenState(
    val articleList: List<ArticleEntity> = emptyList(),
    val isLoading: Boolean = true,
)