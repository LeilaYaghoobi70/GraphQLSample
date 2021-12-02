package com.example.graphqlsample.domain.dataSource.remote

import com.example.preetam.graphqlserversetup.ProfileQuery

interface ProfileRemoteDataSource {
    suspend fun getProfile(): ProfileQuery.Data?
}