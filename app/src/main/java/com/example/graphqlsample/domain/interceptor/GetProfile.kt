package com.example.graphqlsample.domain.interceptor

import com.example.graphqlsample.domain.model.Profile
import com.example.graphqlsample.domain.repository.GithubRepository
import com.example.graphqlsample.persenter.utils.Result
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetProfile
@Inject
constructor(
    private val mGithubRepository: GithubRepository,
){
    fun execute(): Flow<Result<Profile>> = mGithubRepository.gerProfile()
}