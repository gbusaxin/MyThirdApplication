package com.example.mythirdapplication.domain.use_cases

import com.example.mythirdapplication.domain.use_cases.get_locale.GetLocaleUseCase
import com.example.mythirdapplication.domain.use_cases.get_onboarding.GetOnBoardingUseCase
import com.example.mythirdapplication.domain.use_cases.send_request.SendRequestUseCase
import com.example.mythirdapplication.domain.use_cases.set_onboarding.SetOnBoardingUseCase

data class UseCase(
    val getOnBoardingUseCase: GetOnBoardingUseCase,
    val setOnBoardingUseCase: SetOnBoardingUseCase,
    val getLocaleUseCase: GetLocaleUseCase,
    val sendRequestUseCase: SendRequestUseCase
)