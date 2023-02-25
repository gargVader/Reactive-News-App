package com.example.newsapp.presentation.home_screen

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.newsapp.presentation.navigation.Screen
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    context: Context = LocalContext.current,
    viewModel: HomeScreenViewModel = hiltViewModel(
        viewModelStoreOwner = (context as ComponentActivity)
    ),
    navController: NavHostController,
    openWebView: (path : String) -> Unit
) {

    val state = viewModel.state
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isLoading)

    SwipeRefresh(state = swipeRefreshState, onRefresh = { viewModel.getNewsFromApi() }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = state.articleList
            ) { article ->
                ArticleItem(
                    article = article,
                    onCardClick = {
                        article.url?.let {
                            openWebView(Screen.WebViewScreen.passUrl(it))
                        }
                    },
                    onSaveClick = {
                        viewModel.saveArticle(article)
                    })
            }
        }
    }
}