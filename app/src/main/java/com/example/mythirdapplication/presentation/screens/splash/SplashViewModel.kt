package com.example.mythirdapplication.presentation.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.domain.use_cases.UseCase
import com.example.mythirdapplication.utils.ServerResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCase
) : ViewModel() {

    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    private val _serverResponse: MutableStateFlow<ServerResponseState<String?>?> =
        MutableStateFlow(null)
    val serverResponse: StateFlow<ServerResponseState<String?>?> = _serverResponse

    private fun setStateEvent(stateEvent: ServerStateEvent) {
        viewModelScope.launch(Dispatchers.IO) {
            when (stateEvent) {
                is ServerStateEvent.GetServerResponse -> {
                    useCases.sendRequestUseCase().onEach { dataState ->
                        Log.d("CHECK_STATE", dataState.toString())
                        _serverResponse.value = dataState
                    }.launchIn(viewModelScope)
                }
                ServerStateEvent.ServerFailure -> {
                    throw Exception(
                        "Problem with ${this@SplashViewModel::class.java.simpleName} - ServerStateEvent == ServerFailure."
                    )
                }
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setStateEvent(ServerStateEvent.GetServerResponse)
            _onBoardingCompleted.value =
                useCases.getOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }

}

sealed class ServerStateEvent {
    object GetServerResponse : ServerStateEvent()
    object ServerFailure : ServerStateEvent()
}