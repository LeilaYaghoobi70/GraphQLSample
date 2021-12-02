package com.example.graphqlsample.data.dataSource.local

import com.example.graphqlsample.data.db.GraphQLDataBase
import com.example.graphqlsample.data.db.model.ProfileEntity
import com.example.graphqlsample.domain.dataSource.local.ProfileLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

class ProfileLocalDataSourceImp
@Inject
constructor(
    private val graphQLDataBase: GraphQLDataBase,
) : ProfileLocalDataSource {

    override fun getProfile(): Flow<ProfileEntity> =
        graphQLDataBase.profileDao().getProfile().distinctUntilChanged()

    override suspend fun insertProfile(profileEntity: ProfileEntity) =
        graphQLDataBase.profileDao().updateProfile(profileEntity = profileEntity)

}