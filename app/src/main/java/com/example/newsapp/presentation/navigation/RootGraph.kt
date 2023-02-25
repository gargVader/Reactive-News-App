package com.example.newsapp.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsapp.presentation.WebViewScreen

@Composable
fun RootGraph(
    navController: NavHostController,
    navBarController: NavHostController
) {
    NavHost(
        navController = navController,
        route = GRAPH_ROOT,
        startDestination = GRAPH_MAIN
    ) {

        // Define all routes
        composable(route = Screen.WebViewScreen.route + "/{$ARG_URL}", arguments = listOf(
            navArgument(
                name = ARG_URL
            ) {
                type = NavType.StringType
                defaultValue = "www.google.co.in"
                nullable = false
            }
        )) {
            val url = it.arguments?.getString(ARG_URL) ?: ""
            Log.d("Girish", "RootGraph: $url")
            WebViewScreen(url = url, navController = navController)
        }

        composable(route = GRAPH_MAIN) {
            MainScreen(navController = navBarController) {
                navController.navigate(it)
            }
        }

    }


}