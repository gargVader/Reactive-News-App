package com.example.newsapp.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.domain.repository.ArticleRepository
import com.example.newsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repo: ArticleRepository
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            repo.getAllArticles().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }

                    is Resource.Success -> {
                        if (result.data != null) {
                            state = state.copy(articleList = result.data)
                        }
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            articleList = result.data
                        )
                    }
                }
            }
        }
    }

}