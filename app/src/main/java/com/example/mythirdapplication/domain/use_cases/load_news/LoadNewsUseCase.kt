package com.example.mythirdapplication.domain.use_cases.load_news

import com.example.mythirdapplication.data.repository.MainRepository

class LoadNewsUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.loadNews()

}