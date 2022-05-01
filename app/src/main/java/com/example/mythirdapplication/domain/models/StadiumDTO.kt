package com.example.mythirdapplication.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


@Entity(tableName = "stadium_table")
data class StadiumDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("capacity")
    @Expose
    val capacity: String? = null,

    @SerializedName("country")
    @Expose
    val country: String? = null,

    @SerializedName("city")
    @Expose
    val city: String? = null,

    @SerializedName("info")
    @Expose
    val info: String? = null
)