package com.example.mythirdapplication.domain.use_cases.send_request

import com.example.mythirdapplication.data.repository.MainRepository

class SendRequestUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke() = repository.sendRequest()
}