package com.example.mythirdapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.domain.models.StadiumDTO
import com.example.mythirdapplication.domain.models.TourneyDTO

@Dao
interface StadiumDao {

    @Query("SELECT * FROM stadium_table")
    fun getAllStadium(): List<StadiumDTO>

    @Query("SELECT * FROM stadium_table WHERE id =:id")
    suspend fun getSelectedStadium(id: Int): StadiumDTO

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStadium(list: List<StadiumDTO>)

    @Query("DELETE FROM stadium_table")
    suspend fun deleteStadiumData()

}