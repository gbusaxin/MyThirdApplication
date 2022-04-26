package com.example.mythirdapplication.domain.repos

import com.example.mythirdapplication.utils.ServerResponseState
import kotlinx.coroutines.flow.Flow

interface ServerRequestRepos {

    suspend fun sendRequest(): Flow<ServerResponseState<String>>

    fun getLocale(): String

}