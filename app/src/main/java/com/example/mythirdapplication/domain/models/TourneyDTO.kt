package com.example.mythirdapplication.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "tourney_table")
data class TourneyDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("image1")
    @Expose
    val image1: String? = null,

    @SerializedName("image2")
    @Expose
    val image2: String? = null,

    @SerializedName("enemy1")
    @Expose
    val enemy1: String? = null,

    @SerializedName("enemy2")
    @Expose
    val enemy2: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("group")
    @Expose
    val group: String? = null,

    @SerializedName("result")
    @Expose
    val result: String? = null
)