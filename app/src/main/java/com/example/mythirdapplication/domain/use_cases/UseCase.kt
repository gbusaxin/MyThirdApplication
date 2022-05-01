package com.example.mythirdapplication.domain.use_cases

import com.example.mythirdapplication.domain.use_cases.get_locale.GetLocaleUseCase
import com.example.mythirdapplication.domain.use_cases.get_news.GetNewsUseCase
import com.example.mythirdapplication.domain.use_cases.get_onboarding.GetOnBoardingUseCase
import com.example.mythirdapplication.domain.use_cases.get_stadiums.GetStadiumsUseCase
import com.example.mythirdapplication.domain.use_cases.get_tourneys.GetTourneysUseCase
import com.example.mythirdapplication.domain.use_cases.load_news.LoadNewsUseCase
import com.example.mythirdapplication.domain.use_cases.load_stadiums.LoadStadiumsUseCase
import com.example.mythirdapplication.domain.use_cases.load_tourneys.LoadTourneysUseCase
import com.example.mythirdapplication.domain.use_cases.send_request.SendRequestUseCase
import com.example.mythirdapplication.domain.use_cases.set_onboarding.SetOnBoardingUseCase

data class UseCase(
    val getOnBoardingUseCase: GetOnBoardingUseCase,
    val setOnBoardingUseCase: SetOnBoardingUseCase,
    val getLocaleUseCase: GetLocaleUseCase,
    val sendRequestUseCase: SendRequestUseCase,
    val loadNewsUseCase: LoadNewsUseCase,
    val loadStadiumsUseCase: LoadStadiumsUseCase,
    val loadTourneysUseCase: LoadTourneysUseCase,
    val getNewsUseCase: GetNewsUseCase,
    val getTourneysUseCase: GetTourneysUseCase,
    val getStadiumsUseCase: GetStadiumsUseCase
)