package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.data.local.AppDatabase
import com.example.mythirdapplication.data.remote.ApiService
import com.example.mythirdapplication.domain.models.StadiumDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StadiumRepository @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
) {

    private val dao = database.getStadiumDao()

    suspend fun loadStadiums() {
        dao.deleteStadiumData()
        dao.insertStadium(apiService.loadStadiums())
    }

    suspend fun getStadiums(): Flow<List<StadiumDTO>> {
        return flow {
            val dto = dao.getAllStadium()
            emit(dto)
        }
    }

}