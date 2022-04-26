package com.example.mythirdapplication.domain.use_cases.get_locale

import com.example.mythirdapplication.data.repository.MainRepository

class GetLocaleUseCase(
    private val repository: MainRepository
) {
    operator fun invoke() = repository.getLocale()
}