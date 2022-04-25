package com.example.mythirdapplication.domain.use_cases

import com.example.mythirdapplication.domain.use_cases.get_onboarding.GetOnBoardingUseCase
import com.example.mythirdapplication.domain.use_cases.set_onboarding.SetOnBoardingUseCase

data class UseCase(
    val getOnBoardingUseCase: GetOnBoardingUseCase,
    val setOnBoardingUseCase: SetOnBoardingUseCase
)