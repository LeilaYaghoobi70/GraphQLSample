package com.example.graphqlsample.domain.interceptor

import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.domain.repository.GithubRepository
import com.example.graphqlsample.persenter.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRepository
@Inject
constructor(
    private val mGithubRepository: GithubRepository,
) {
    fun execute(size: Int): Flow<Result<List<Repository>?>> = mGithubRepository.getRepository(size)
}