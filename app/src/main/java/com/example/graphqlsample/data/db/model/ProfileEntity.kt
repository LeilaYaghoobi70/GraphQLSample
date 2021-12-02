package com.example.graphqlsample.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "bio")
    val bio: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "avatarUrl")
    val avatarUrl: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "createdAt")
    val createdAt: String,
    @ColumnInfo(name = "name")
    val name: String,
)