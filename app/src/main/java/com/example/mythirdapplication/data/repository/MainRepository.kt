package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.domain.models.StadiumDTO
import com.example.mythirdapplication.domain.models.TourneyDTO
import com.example.mythirdapplication.domain.repos.OnBoardingRepos
import com.example.mythirdapplication.domain.repos.ServerRequestRepos
import com.example.mythirdapplication.utils.ServerResponseState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val onBoarding: OnBoardingRepos,
    private val serverRepos: ServerRequestRepos,
    private val newsService: NewsService,
    private val tourneyRepository: TourneyRepository,
    private val stadiumRepository: StadiumRepository
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

    suspend fun getNews():Flow<List<NewsDTO>>{
        return newsService.getNewsFlow()
    }

    suspend fun loadNews(){
        newsService.loadNews()
    }

    suspend fun getTourney():Flow<List<TourneyDTO>>{
        return tourneyRepository.getTourneys()
    }

    suspend fun loadTourney(){
        tourneyRepository.loadTourney()
    }

    suspend fun getStadium():Flow<List<StadiumDTO>>{
        return stadiumRepository.getStadiums()
    }

    suspend fun loadStadium(){
        stadiumRepository.loadStadiums()
    }


}