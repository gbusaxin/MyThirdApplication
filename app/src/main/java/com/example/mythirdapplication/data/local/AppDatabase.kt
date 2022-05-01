package com.example.mythirdapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.domain.models.StadiumDTO
import com.example.mythirdapplication.domain.models.TourneyDTO

@Database(
    entities = [
        NewsDTO::class,
        StadiumDTO::class,
        TourneyDTO::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao
    abstract fun getStadiumDao(): StadiumDao
    abstract fun getTourneyDao(): TourneyDao

}