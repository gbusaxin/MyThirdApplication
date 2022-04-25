package com.example.mythirdapplication.domain.repos

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepos {

    suspend fun setOnBoardingState(completed: Boolean)

    fun getOnBoardingState(): Flow<Boolean>

}