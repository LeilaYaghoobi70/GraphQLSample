package com.example.graphqlsample.domain.dataSource.remote

import com.example.preetam.graphqlserversetup.GetRepositoryQuery

interface RepositoryRemoteDataSource {
    suspend fun getRepositories(size: Int): GetRepositoryQuery.Data?
}