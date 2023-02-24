package com.example.newsapp.presentation.home_screen

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    context: Context = LocalContext.current,
    viewModel: HomeScreenViewModel = hiltViewModel(
        viewModelStoreOwner = (context as ComponentActivity)
    )
) {

}