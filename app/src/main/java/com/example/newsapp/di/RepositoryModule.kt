package com.example.newsapp.di

import com.example.newsapp.data.repository.ArticleRepositoryImpl
import com.example.newsapp.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsArticleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository

}