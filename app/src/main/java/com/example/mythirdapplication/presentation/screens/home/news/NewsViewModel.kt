package com.example.mythirdapplication.presentation.screens.home.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.domain.use_cases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    useCase: UseCase
) : ViewModel() {


    private var _newsList = MutableStateFlow<List<NewsDTO>>(Collections.emptyList())
    val newsList: Flow<List<NewsDTO>> = _newsList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.loadNewsUseCase()
            useCase.getNewsUseCase().collect {
                _newsList.value = it
            }
        }
    }
}