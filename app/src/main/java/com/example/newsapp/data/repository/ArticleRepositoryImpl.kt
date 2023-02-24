package com.example.newsapp.data.repository

import com.example.newsapp.data.local.ArticleDao
import com.example.newsapp.data.mapper.toArticleEntity
import com.example.newsapp.data.model.ArticleEntity
import com.example.newsapp.data.model.NewsApiResponse
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.domain.repository.ArticleRepository
import com.example.newsapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val dao: ArticleDao,
    private val api: NewsApi,
) : ArticleRepository {
    override fun getAllArticles(): Flow<Resource<List<ArticleEntity>>> {
        return flow {
            emit(Resource.Loading(true))
            val response: NewsApiResponse? = try {
                api.getTopHeadlines()
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = e.message!!))
                null
            }

            response?.let {
                emit(
                    Resource.Success(
                        data = response.articles.map { it.toArticleEntity() })
                )
            }
            emit(Resource.Loading(false))
        }
    }

    override fun getSavedArticles(): Flow<List<ArticleEntity>> {
        return dao.getAllArticles()
    }

    override suspend fun insert(article: ArticleEntity): Long {
        return dao.insert(article)
    }

    override suspend fun delete(id: Long) {
        dao.delete(id)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}