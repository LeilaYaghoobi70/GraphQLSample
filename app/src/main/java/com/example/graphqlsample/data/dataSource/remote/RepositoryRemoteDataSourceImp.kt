package com.example.graphqlsample.data.dataSource.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.example.graphqlsample.domain.dataSource.remote.RepositoryRemoteDataSource
import com.example.preetam.graphqlserversetup.GetRepositoryQuery
import javax.inject.Inject

class RepositoryRemoteDataSourceImp
@Inject
constructor(
    private val mApolloClient: ApolloClient,
) : RepositoryRemoteDataSource {
    override suspend fun getRepositories(size: Int): GetRepositoryQuery.Data? =
        mApolloClient.query(GetRepositoryQuery(size = Input.optional(size))).await().data
}