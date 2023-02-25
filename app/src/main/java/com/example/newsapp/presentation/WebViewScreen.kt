package com.example.newsapp.presentation

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun WebViewScreen(
    url: String,
    navController: NavHostController
) {
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()

            loadUrl(url)
        }
    })

}