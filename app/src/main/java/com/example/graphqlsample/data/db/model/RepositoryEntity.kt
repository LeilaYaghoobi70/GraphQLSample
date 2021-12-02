package com.example.graphqlsample.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository_table")
data class RepositoryEntity(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: String,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="createdAt")
    val createdAt: String,
    @ColumnInfo(name="description")
    val description: String,
)