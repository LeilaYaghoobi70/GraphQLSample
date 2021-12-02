package com.example.graphqlsample.data.repository

import com.example.graphqlsample.data.db.model.RepositoryEntity
import com.example.graphqlsample.data.mapper.mapToDomain
import com.example.graphqlsample.data.mapper.mapToEntity
import com.example.graphqlsample.domain.dataSource.local.ProfileLocalDataSource
import com.example.graphqlsample.domain.dataSource.local.RepositoryLocalDataSource
import com.example.graphqlsample.domain.dataSource.remote.ProfileRemoteDataSource
import com.example.graphqlsample.domain.dataSource.remote.RepositoryRemoteDataSource
import com.example.graphqlsample.domain.model.Profile
import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.domain.repository.GithubRepository
import com.example.graphqlsample.persenter.utils.Result
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GithubRepositoryImp
@Inject
constructor(
    private val mProfileLocalDataSource: ProfileLocalDataSource,
    private val mRepositoryLocalDataSource: RepositoryLocalDataSource,
    private val mProfileRemoteDataSource: ProfileRemoteDataSource,
    private val mRepositoryRemoteDataSource: RepositoryRemoteDataSource,
    private val dispatcher: CoroutineContext,
) : GithubRepository {

    override fun gerProfile(): Flow<Result<Profile>> = flow {
        emit(Result.Loading)
        val getLocalDao = mProfileLocalDataSource.getProfile().map {
            Result.Success(it.mapToDomain())
        }
        mProfileRemoteDataSource.getProfile()?.let {
            mProfileLocalDataSource.insertProfile(it.mapToEntity())
        }
        emitAll(getLocalDao)
    }.catch {
        emit(Result.Error(it))
    }.flowOn(dispatcher)

    override fun getRepository(size: Int): Flow<Result<List<Repository>>> = flow {
        emit(Result.Loading)
        val getLocal = mRepositoryLocalDataSource.getRepositories()
            .map { repositories: List<RepositoryEntity> ->
                Result.Success(repositories.map {
                    it.mapToDomain()
                })
            }

        val getRemote = mRepositoryRemoteDataSource.getRepositories(size)
        getRemote?.mapToEntity()?.forEach {
            mRepositoryLocalDataSource.insertRepositories(it.mapToEntity())
        }
        emitAll(getLocal)
    }.catch {
        emit(Result.Error(it))
    }.flowOn(dispatcher)

}

