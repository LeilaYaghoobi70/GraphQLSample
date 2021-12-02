package com.example.graphqlsample.di

import com.example.graphqlsample.domain.repository.GithubRepository
import com.example.graphqlsample.data.repository.GithubRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideGithubRepository(githubRepository: GithubRepositoryImp): GithubRepository
}
