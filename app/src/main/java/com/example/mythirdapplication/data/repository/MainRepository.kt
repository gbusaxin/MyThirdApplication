package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.domain.repos.OnBoardingRepos
import com.example.mythirdapplication.domain.repos.ServerRequestRepos
import com.example.mythirdapplication.utils.ServerResponseState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val onBoarding: OnBoardingRepos,
    private val serverRepos: ServerRequestRepos
) {

    fun getOnBoardingState(): Flow<Boolean> {
        return onBoarding.getOnBoardingState()
    }

    suspend fun setOnBoardingState(completed: Boolean) {
        onBoarding.setOnBoardingState(completed = completed)
    }

    suspend fun sendRequest(): Flow<ServerResponseState<String>> {
        return serverRepos.sendRequest()
    }

    fun getLocale(): String {
        return serverRepos.getLocale()
    }

}