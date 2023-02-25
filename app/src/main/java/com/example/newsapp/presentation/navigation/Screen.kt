package com.example.newsapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

const val GRAPH_ROOT = "root_graph"
const val GRAPH_MAIN = "app_graph"
const val GRAPH_BOTTOM_NAV = "bottom_nav_graph"

const val ARG_URL = "url"

sealed class Screen(
    val route: String,
    val icon: ImageVector,
    val label: String,
) {
    object HomeScreen : Screen("home", Icons.Default.Home, "Home")
    object SavedScreen : Screen("saved", Icons.Default.Bookmark, "Saved")
    object WebViewScreen : Screen("webview", Icons.Default.Bookmark, "webview"){
        fun passUrl(url : String) : String{
            val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
            return "$route/$encodedUrl"
        }
    }
}