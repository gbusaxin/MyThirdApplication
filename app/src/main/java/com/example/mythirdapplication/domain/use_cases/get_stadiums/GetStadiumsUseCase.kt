package com.example.mythirdapplication.domain.use_cases.get_stadiums

import com.example.mythirdapplication.data.repository.MainRepository

class GetStadiumsUseCase(
    private val repository: MainRepository
) {

    suspend operator fun invoke() = repository.getStadium()

}