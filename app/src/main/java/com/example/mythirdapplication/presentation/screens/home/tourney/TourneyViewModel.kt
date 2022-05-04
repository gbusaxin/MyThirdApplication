package com.example.mythirdapplication.presentation.screens.home.tourney

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.domain.models.TourneyDTO
import com.example.mythirdapplication.domain.use_cases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TourneyViewModel @Inject constructor(
    useCase: UseCase
) : ViewModel() {

    private val _tourneysListState = MutableStateFlow<List<TourneyDTO>>(Collections.emptyList())
    val tourneysListState: Flow<List<TourneyDTO>> = _tourneysListState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.loadTourneysUseCase()
            useCase.getTourneysUseCase().collect {
                _tourneysListState.value = it
            }
        }
    }

}