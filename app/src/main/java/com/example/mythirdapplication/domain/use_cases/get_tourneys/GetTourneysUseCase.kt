package com.example.mythirdapplication.domain.use_cases.get_tourneys

import com.example.mythirdapplication.data.repository.MainRepository

class GetTourneysUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.getTourney()

}