package com.example.graphqlsample.di

import android.content.Context
import androidx.room.Room
import com.example.graphqlsample.data.db.GraphQLDataBase
import com.example.graphqlsample.persenter.utils.Constant.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideGraphQLDataBase(@ApplicationContext context: Context): GraphQLDataBase {
        return Room.databaseBuilder(
            context,
            GraphQLDataBase::class.java,
            DB_NAME
        ).build()
    }
}