package com.example.newsapp.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.ArticleEntity
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
        getNewsFromApi()
    }

    fun saveArticle(articleEntity: ArticleEntity) {
        viewModelScope.launch {
            repo.insert(articleEntity)
        }
    }

    fun getNewsFromApi() {
        viewModelScope.launch {
            repo.getAllArticles().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }

                    is Resource.Success -> {
                        if (result.data != null) {
                            Log.d("Girish", "getNewsFromApi: ${result.data}")
                            state = state.copy(articleList = result.data)
                        }
                    }

                    is Resource.Error -> {
                        state = state.copy(isLoading = false)
                    }
                }
            }
        }
    }

}