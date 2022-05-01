package com.example.mythirdapplication.domain.use_cases.load_tourneys

import com.example.mythirdapplication.data.repository.MainRepository

class LoadTourneysUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.loadTourney()

}