package com.example.graphqlsample.domain.dataSource.local

import com.example.graphqlsample.data.db.model.RepositoryEntity
import kotlinx.coroutines.flow.Flow

interface RepositoryLocalDataSource {
    fun getRepositories(): Flow<List<RepositoryEntity>>
    suspend fun insertRepositories(repositoryEntity: RepositoryEntity)
}