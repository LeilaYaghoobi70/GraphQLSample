package com.example.graphqlsample.di

import com.apollographql.apollo.ApolloClient
import com.example.graphqlsample.BuildConfig
import com.example.graphqlsample.persenter.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApolloModule {

    @Provides
    fun provideInterceptor() = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .header("Authorization", "Bearer " + BuildConfig.TOKEN)
            .build()
        chain.proceed(request)
    }

    @Singleton
    @Provides
    fun provideApollo(interceptor: Interceptor): ApolloClient =
        ApolloClient.builder().serverUrl(BASE_URL).okHttpClient(OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        ).build()

}