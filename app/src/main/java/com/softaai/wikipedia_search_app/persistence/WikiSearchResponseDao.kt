package com.softaai.wikipedia_search_app.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softaai.wikipedia_search_app.model.Page
import kotlinx.coroutines.flow.Flow

@Dao
interface WikiSearchResponseDao {

    @Query("SELECT * FROM Page")
    fun getAllWikiPages(): Flow<List<Page>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(page: Page)

    @Query("DELETE FROM Page")
    suspend fun deleteAll()
}
