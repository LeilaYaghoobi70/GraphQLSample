package com.example.graphqlsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.graphqlsample.data.db.model.ProfileEntity
import com.example.graphqlsample.data.db.model.RepositoryEntity

@Database(entities = [ProfileEntity::class, RepositoryEntity::class], version = 1)
abstract class GraphQLDataBase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
    abstract fun profileDao(): ProfileDao
}