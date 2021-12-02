package com.example.graphqlsample.data.mapper

import com.example.graphqlsample.data.db.model.ProfileEntity
import com.example.graphqlsample.data.db.model.RepositoryEntity
import com.example.graphqlsample.domain.model.Profile
import com.example.graphqlsample.domain.model.Repository
import com.example.graphqlsample.persenter.utils.Constant.EMPTY_STRING
import com.example.preetam.graphqlserversetup.GetRepositoryQuery
import com.example.preetam.graphqlserversetup.ProfileQuery

fun ProfileQuery.Data.mapToEntity() = ProfileEntity(
    login = viewer.login,
    bio = viewer.bio ?: EMPTY_STRING,
    email = viewer.email,
    avatarUrl = if (viewer.avatarUrl is String) viewer.avatarUrl else EMPTY_STRING,
    url = if (viewer.url is String) viewer.url else EMPTY_STRING,
    name = viewer.name ?: EMPTY_STRING,
    createdAt = if (viewer.createdAt is String) viewer.createdAt else EMPTY_STRING,
)

fun GetRepositoryQuery.Data.mapToEntity() =
    this.viewer.repositories.edges?.map {
        Repository(
            id = it?.node?.id ?: EMPTY_STRING,
            name = it?.node?.name ?: EMPTY_STRING,
            createdAt = (if (it?.node?.createdAt is String) it.node.createdAt else EMPTY_STRING) as String,
            description = it?.node?.description ?: EMPTY_STRING,
        )
    }

fun ProfileEntity.mapToDomain() =
    Profile(
        login = login,
        bio = bio,
        email = email,
        avatarUrl = avatarUrl,
        url = url,
        name = name,
        createdAt = createdAt,
    )

fun RepositoryEntity.mapToDomain() =
    Repository(
        id = id,
        name = name,
        createdAt = createdAt,
        description = description,
    )

fun Repository.mapToEntity() =
    RepositoryEntity(
        id = id,
        name = name,
        createdAt = createdAt,
        description = description,
    )

