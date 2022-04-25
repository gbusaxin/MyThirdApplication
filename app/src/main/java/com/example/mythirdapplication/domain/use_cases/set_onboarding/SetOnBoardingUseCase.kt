package com.example.mythirdapplication.domain.use_cases.set_onboarding

import com.example.mythirdapplication.data.repository.MainRepository

class SetOnBoardingUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke(completed: Boolean) =
        repository.setOnBoardingState(completed = completed)
}