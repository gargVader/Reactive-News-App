package com.example.newsapp.presentation.saved_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedScreenViewModel @Inject constructor(
    private val repo: ArticleRepository
) : ViewModel() {

    var state by mutableStateOf(SavedScreenState())

    init {
        getSavedArticles()
    }

    private fun getSavedArticles() {
        viewModelScope.launch {
            repo.getSavedArticles().collect {
                state = state.copy(it)
            }
        }
    }

    fun deleteAllArticles() {
        viewModelScope.launch {
            repo.deleteAll()
        }
    }

}