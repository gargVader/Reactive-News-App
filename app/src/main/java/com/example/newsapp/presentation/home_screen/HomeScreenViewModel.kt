package com.example.newsapp.presentation.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.remote.NewsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val api: NewsApi
) : ViewModel() {

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            val response = try {
                api.getTopHeadlines()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            Log.d("Girish", "getNews: $response")
        }
    }

}