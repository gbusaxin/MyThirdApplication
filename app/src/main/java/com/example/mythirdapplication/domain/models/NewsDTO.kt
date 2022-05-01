package com.example.mythirdapplication.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "news_table")
data class NewsDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String? = null,
    @SerializedName("date")
    @Expose
    val date: String? = null,
    @SerializedName("body")
    @Expose
    val body: String? = null
)