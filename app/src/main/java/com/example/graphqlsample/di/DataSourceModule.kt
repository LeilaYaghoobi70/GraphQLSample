package com.example.graphqlsample.di

import com.example.graphqlsample.data.dataSource.local.ProfileLocalDataSourceImp
import com.example.graphqlsample.data.dataSource.local.RepositoryLocalDataSourceImp
import com.example.graphqlsample.data.dataSource.remote.ProfileRemoteDataSourceImp
import com.example.graphqlsample.data.dataSource.remote.RepositoryRemoteDataSourceImp
import com.example.graphqlsample.domain.dataSource.local.ProfileLocalDataSource
import com.example.graphqlsample.domain.dataSource.local.RepositoryLocalDataSource
import com.example.graphqlsample.domain.dataSource.remote.ProfileRemoteDataSource
import com.example.graphqlsample.domain.dataSource.remote.RepositoryRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun provideProfileRemote(profileRemoteDataSource: ProfileRemoteDataSourceImp): ProfileRemoteDataSource

    @Binds
    @Singleton
    fun provideProfileLocal(profileLocalDataSourceImp: ProfileLocalDataSourceImp): ProfileLocalDataSource

    @Binds
    @Singleton
    fun provideRepositoryRemote(repositoryRemoteDataSource: RepositoryRemoteDataSourceImp): RepositoryRemoteDataSource

    @Binds
    @Singleton
    fun provideRepositoryLocal(repositoryLocalDataSource: RepositoryLocalDataSourceImp): RepositoryLocalDataSource


}