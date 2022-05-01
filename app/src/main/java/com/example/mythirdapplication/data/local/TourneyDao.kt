package com.example.mythirdapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.domain.models.TourneyDTO

@Dao
interface TourneyDao {

    @Query("SELECT * FROM tourney_table")
    fun getAllTourney(): List<TourneyDTO>

    @Query("SELECT * FROM tourney_table WHERE id =:id")
    suspend fun getSelectedTourney(id: Int): TourneyDTO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourney(list: List<TourneyDTO>)

    @Query("DELETE FROM tourney_table")
    suspend fun deleteTourneyData()

}