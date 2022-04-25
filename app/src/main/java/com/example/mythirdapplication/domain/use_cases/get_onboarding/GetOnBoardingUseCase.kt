package com.example.mythirdapplication.domain.use_cases.get_onboarding

import com.example.mythirdapplication.data.repository.MainRepository

class GetOnBoardingUseCase(
    private val repository: MainRepository
) {
    operator fun invoke() = repository.getOnBoardingState()
}