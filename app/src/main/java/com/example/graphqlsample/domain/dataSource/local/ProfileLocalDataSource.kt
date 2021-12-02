package com.example.graphqlsample.domain.dataSource.local

import com.example.graphqlsample.data.db.model.ProfileEntity
import kotlinx.coroutines.flow.Flow

interface ProfileLocalDataSource {
    fun getProfile(): Flow<ProfileEntity>
    suspend fun insertProfile(profileEntity: ProfileEntity)
}