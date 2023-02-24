package com.example.newsapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val icon: ImageVector,
    val label: String,
) {
    object HomeScreen : Screen("home", Icons.Default.Home, "Home")
    object SavedScreen : Screen("saved", Icons.Default.Bookmark, "Saved")
}