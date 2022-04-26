package com.example.mythirdapplication.presentation.screens.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.domain.use_cases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    fun setOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.setOnBoardingUseCase(completed = completed)
        }
    }

}