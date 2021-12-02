package com.example.graphqlsample.data.db

import androidx.room.*
import com.example.graphqlsample.data.db.model.ProfileEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile_table")
    fun getProfile(): Flow<ProfileEntity>


    @Query("DELETE FROM profile_table")
    suspend fun deleteProfileEntity()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfileEntity(profileEntity: ProfileEntity)

    @Transaction
    suspend fun updateProfile(profileEntity: ProfileEntity) {
        profileEntity.let {
            deleteProfileEntity()
            insertProfileEntity(it)
        }
    }
}