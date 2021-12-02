package com.example.graphqlsample.data.dataSource.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.example.graphqlsample.domain.dataSource.remote.ProfileRemoteDataSource
import com.example.preetam.graphqlserversetup.ProfileQuery
import javax.inject.Inject

class ProfileRemoteDataSourceImp
@Inject
constructor(
    private val mApolloClient: ApolloClient,
) : ProfileRemoteDataSource {
    override suspend fun getProfile(): ProfileQuery.Data? =
        mApolloClient.query(ProfileQuery()).await().data
}