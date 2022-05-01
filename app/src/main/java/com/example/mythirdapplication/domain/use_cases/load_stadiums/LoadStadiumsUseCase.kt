package com.example.mythirdapplication.domain.use_cases.load_stadiums

import com.example.mythirdapplication.data.repository.MainRepository

class LoadStadiumsUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.loadStadium()

}