package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.data.local.AppDatabase
import com.example.mythirdapplication.data.remote.ApiService
import com.example.mythirdapplication.domain.models.NewsDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsService @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
) {

    private val dao = database.getNewsDao()

    suspend fun loadNews() {
        dao.deleteNewsData()
        dao.insertNews(apiService.loadNews())
    }

    suspend fun getNewsFlow(): Flow<List<NewsDTO>> {
        return flow {
            val news = dao.getAllNews()
            emit(news)
        }
    }

}