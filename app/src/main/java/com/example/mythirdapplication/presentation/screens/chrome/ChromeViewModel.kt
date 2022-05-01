package com.example.mythirdapplication.presentation.screens.chrome

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mythirdapplication.navigation.ARGUMENT_RESPONSE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class ChromeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _linkResponse: MutableStateFlow<String?> = MutableStateFlow(value = null)
    val linkResponse: StateFlow<String?> = _linkResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val key = savedStateHandle.get<String>(ARGUMENT_RESPONSE)
            val decodedKey = URLDecoder.decode(key, StandardCharsets.UTF_8.toString())
            _linkResponse.value = decodedKey
        }
    }

}