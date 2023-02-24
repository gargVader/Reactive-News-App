package com.example.newsapp.presentation.home_screen

import androidx.compose.runtime.Composable
import com.example.newsapp.data.model.ArticleEntity
import com.example.newsapp.presentation.common.ArticleCard

@Composable
fun ArticleItem(
    article: ArticleEntity,
    onSaveClick: () -> Unit,
    onCardClick: () -> Unit
) =
    ArticleCard(
        article = article,
        onSaveClick = onSaveClick,
        onCardClick = onCardClick,
        showSaveButton = true,
    )