package com.example.mythirdapplication.domain.use_cases.get_news

import com.example.mythirdapplication.data.repository.MainRepository

class GetNewsUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.getNews()
}