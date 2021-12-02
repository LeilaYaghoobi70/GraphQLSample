package com.example.graphqlsample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.graphqlsample.data.db.model.RepositoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RepositoryDao {

    @Query("SELECT * FROM repository_table")
    fun getRepositories(): Flow<List<RepositoryEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRepository(repositoryEntity: RepositoryEntity)
}