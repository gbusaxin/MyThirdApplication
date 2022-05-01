package com.example.mythirdapplication.data.repository

import com.example.mythirdapplication.data.local.AppDatabase
import com.example.mythirdapplication.data.remote.ApiService
import javax.inject.Inject

class NewsService @Inject constructor(
    private val apiService: ApiService,
    private val database: AppDatabase
) {


}