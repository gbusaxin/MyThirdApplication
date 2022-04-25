package com.example.mythirdapplication.utils

sealed class ServerResponseState<out R>{

    data class Success<out T>(val data: T) : ServerResponseState<T>()

    data class Error(val exception: Exception) : ServerResponseState<Nothing>()

    object Loading : ServerResponseState<Nothing>()

}
