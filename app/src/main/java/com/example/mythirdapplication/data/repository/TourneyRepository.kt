package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.data.local.AppDatabase
import com.example.mythirdapplication.data.remote.ApiService
import com.example.mythirdapplication.domain.models.TourneyDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TourneyRepository @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
) {

    private val dao = database.getTourneyDao()

    suspend fun loadTourney() {
        dao.deleteTourneyData()
        dao.insertTourney(apiService.loadTourney())
    }

    suspend fun getTourneys(): Flow<List<TourneyDTO>> {
        return flow {
            val dto = dao.getAllTourney()
            emit(dto)
        }
    }

}