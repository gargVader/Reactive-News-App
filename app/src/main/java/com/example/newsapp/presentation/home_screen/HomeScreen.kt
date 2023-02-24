package com.example.newsapp.presentation.home_screen

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    context: Context = LocalContext.current,
    viewModel: HomeScreenViewModel = hiltViewModel(
        viewModelStoreOwner = (context as ComponentActivity)
    )
) {

    val state = viewModel.state
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isLoading,
        onRefresh = { viewModel.getNewsFromApi() })

    Box(
        modifier = Modifier
            .pullRefresh(state = pullRefreshState, enabled = true)
            .padding(start = 12.dp, end = 12.dp)
    ) {

        PullRefreshIndicator(state.isLoading, pullRefreshState, Modifier.align(Alignment.TopCenter))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = state.articleList
            ) { article ->
                ArticleItem(article = article, onCardClick = {}, onSaveClick = {
                    viewModel.saveArticle(article)
                })
            }
        }
    }
}