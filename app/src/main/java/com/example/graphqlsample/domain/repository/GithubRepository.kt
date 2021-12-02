package com.example.graphqlsample.domain.repository

import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.domain.model.Profile
import com.example.graphqlsample.persenter.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GithubRepository {
    fun gerProfile(): Flow<Result<Profile>>
    fun getRepository(size: Int): Flow<Result<List<Repository>?>>
}