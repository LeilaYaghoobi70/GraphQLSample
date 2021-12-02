package com.example.graphqlsample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


@Module
@InstallIn(SingletonComponent::class)
class DispatchersModule {

    @Provides
    fun provideDispatchers(): CoroutineContext = Dispatchers.IO
}