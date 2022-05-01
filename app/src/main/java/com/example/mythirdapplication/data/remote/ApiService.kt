package com.example.mythirdapplication.data.remote

import com.example.mythirdapplication.data.remote.model.RequestDto
import com.example.mythirdapplication.data.remote.model.ResponseDto
import com.example.mythirdapplication.domain.models.NewsDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/second_app/response/splash.php")
    suspend fun sendRequest(@Body locale: RequestDto): ResponseDto

    @GET("/iihf/iihf_news.json")
    suspend fun loadNews(): List<NewsDTO>

    @GET("/iihf/iihf_tourney.json")
    suspend fun loadTourney()// TODO

    @GET("/iihf/iihf_stadiums.json")
    suspend fun loadStadiums() // TODO

}