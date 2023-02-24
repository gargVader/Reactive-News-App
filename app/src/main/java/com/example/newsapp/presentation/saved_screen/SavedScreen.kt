package com.example.newsapp.presentation.saved_screen

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SavedScreen(
    context: Context = LocalContext.current,
    viewModel: SavedScreenViewModel = hiltViewModel(
        viewModelStoreOwner = (context as ComponentActivity)
    )
) {

    val state = viewModel.state

    Column(modifier = Modifier.padding(start = 12.dp, end = 12.dp)) {

        if (state.articleList.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No articles saved")
            }
        } else {
            TextButton(
                onClick = { viewModel.deleteAllArticles() },
                modifier = Modifier.align(End)
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Delete All")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = state.articleList
                ) { article ->
                    SavedArticleItem(article = article, onCardClick = {})
                }
            }
        }

    }

}