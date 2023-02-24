package com.example.newsapp.data.remote

import com.example.newsapp.BuildConfig
import com.example.newsapp.data.model.NewsApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
 https://newsapi.org/v2/top-headlines?country=us&apiKey=7b3ba7e882e14c1d996c6bd6b0ac0d89
 */
interface NewsApi {

    @GET("{path}")
    suspend fun getTopHeadlines(
        @Path("path") path: String = PATH_TOP_HEADLINES,
        @Query("country") country: String = DEFAULT_PARAM_COUNTRY,
        @Query("apiKey") apiKey: String = API_KEY,
    ): NewsApiResponse

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val PATH_TOP_HEADLINES = "top-headlines"

        const val DEFAULT_PARAM_COUNTRY = "in"
        const val API_KEY = BuildConfig.NEWS_API_KEY
    }
}