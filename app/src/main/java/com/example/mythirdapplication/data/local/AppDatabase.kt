package com.example.mythirdapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mythirdapplication.domain.models.NewsDTO

@Database(
    entities = [
        NewsDTO::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // TODO: abstract fun getNewsDao():NewsDao

}