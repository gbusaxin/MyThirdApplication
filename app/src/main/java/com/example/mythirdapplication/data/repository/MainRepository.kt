package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.domain.repos.OnBoardingRepos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val onBoarding: OnBoardingRepos
) {

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoarding.getOnBoardingState()
    }

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoarding.setOnBoardingState(completed = completed)
    }

}