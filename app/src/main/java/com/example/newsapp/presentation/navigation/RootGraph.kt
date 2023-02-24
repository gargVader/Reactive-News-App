package com.example.newsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.presentation.home_screen.HomeScreen
import com.example.newsapp.presentation.saved_screen.SavedScreen

@Composable
fun RootGraph(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(
        navController,
        startDestination = Screen.HomeScreen.route,
        Modifier.padding(innerPadding)
    ) {

        // Define all routes
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
        }

        composable(
            Screen.SavedScreen.route
        ) {
            SavedScreen()
        }
    }
}