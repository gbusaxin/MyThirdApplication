package com.example.mythirdapplication.data.repository

import android.content.res.Resources
import androidx.core.os.ConfigurationCompat
import com.example.mythirdapplication.data.remote.ApiService
import com.example.mythirdapplication.data.remote.model.RequestDto
import com.example.mythirdapplication.domain.repos.ServerRequestRepos
import com.example.mythirdapplication.utils.ServerResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class ServerRequestReposImpl(
    private val apiService: ApiService
) : ServerRequestRepos {

    override suspend fun sendRequest(): Flow<ServerResponseState<String>> {
        return flow {
            emit(ServerResponseState.Loading)
            try {
                val locale = getLocale()
                val request = RequestDto(request = locale)
                val response = apiService.sendRequest(locale = request)
                if (response.url != "no") {
                    val encodedUrl = getEncodeUrl(response.url)
                    emit(ServerResponseState.Success(encodedUrl))
                } else {
                    emit(ServerResponseState.Error(Exception("Server's response is equal ${response.url}")))
                }
            } catch (e: Exception) {
                emit(ServerResponseState.Error(exception = e))
            }
        }
    }

    private fun getEncodeUrl(url: String): String {
        return URLEncoder.encode(
            url,
            StandardCharsets.UTF_8.toString()
        )
    }

    override fun getLocale(): String {
        val locale = ConfigurationCompat.getLocales(Resources.getSystem().configuration)
        val lang = locale[0]
        return lang.isO3Language
    }

}