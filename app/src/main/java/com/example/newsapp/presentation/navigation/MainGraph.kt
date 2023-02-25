package com.example.newsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsapp.presentation.home_screen.HomeScreen
import com.example.newsapp.presentation.saved_screen.SavedScreen

@Composable
fun MainGraph(navController: NavHostController, openWebView: (path : String) -> Unit) {

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
    ) {

        // Define all routes
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController = navController, openWebView = openWebView)
        }

        composable(
            Screen.SavedScreen.route
        ) {
            SavedScreen(navController = navController, openWebView = openWebView)
        }
    }
}