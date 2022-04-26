package com.example.mythirdapplication.data.remote

import com.example.mythirdapplication.data.remote.model.RequestDto
import com.example.mythirdapplication.data.remote.model.ResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/second_app/response/splash.php")
    suspend fun sendRequest(@Body locale: RequestDto): ResponseDto

}