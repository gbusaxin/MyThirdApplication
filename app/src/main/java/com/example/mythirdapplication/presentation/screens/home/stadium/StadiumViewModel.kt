package com.example.mythirdapplication.presentation.screens.home.stadium

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.domain.models.StadiumDTO
import com.example.mythirdapplication.domain.use_cases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class StadiumViewModel @Inject constructor(
    useCase: UseCase
) : ViewModel() {

    private val _stadiumsListState = MutableStateFlow<List<StadiumDTO>>(Collections.emptyList())
    val stadiumsListState: Flow<List<StadiumDTO>> = _stadiumsListState


    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.loadStadiumsUseCase()
            useCase.getStadiumsUseCase().collect {
                _stadiumsListState.value = it
            }

        }
    }

}