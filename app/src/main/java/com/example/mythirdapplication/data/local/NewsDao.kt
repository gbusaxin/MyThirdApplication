package com.example.mythirdapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mythirdapplication.domain.models.NewsDTO

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_table")
    fun getAllNews(): List<NewsDTO>

    @Query("SELECT * FROM news_table WHERE id =:id")
    suspend fun getSelectedNews(id: Int): NewsDTO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(list: List<NewsDTO>)

    @Query("DELETE FROM news_table")
    suspend fun deleteNewsData()

}