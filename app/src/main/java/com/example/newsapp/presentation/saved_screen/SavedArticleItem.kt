package com.example.newsapp.presentation.saved_screen

import androidx.compose.runtime.Composable
import com.example.newsapp.data.model.ArticleEntity
import com.example.newsapp.presentation.common.ArticleCard

@Composable
fun SavedArticleItem(
    article: ArticleEntity,
    onCardClick: () -> Unit
) =
    ArticleCard(
        article = article,
        onSaveClick = {},
        onCardClick = onCardClick,
    )