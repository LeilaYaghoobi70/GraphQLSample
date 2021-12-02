package com.example.graphqlsample.data.dataSource.local

import com.example.graphqlsample.data.db.GraphQLDataBase
import com.example.graphqlsample.data.db.model.RepositoryEntity
import com.example.graphqlsample.domain.dataSource.local.RepositoryLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class RepositoryLocalDataSourceImp
@Inject constructor(
    private val graphQLDataBase: GraphQLDataBase,
) : RepositoryLocalDataSource {


    override fun getRepositories(): Flow<List<RepositoryEntity>> =
        graphQLDataBase.repositoryDao().getRepositories().distinctUntilChanged()

    override suspend fun insertRepositories(repositoryEntity: RepositoryEntity) =
        graphQLDataBase.repositoryDao().insertRepository(repositoryEntity = repositoryEntity)
}