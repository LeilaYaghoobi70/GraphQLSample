package com.example.graphqlsample.domain.model

data class Profile(
    val login: String,
    val bio: String,
    val email: String,
    val avatarUrl:String,
    val url:String,
    val createdAt:String,
    val name:String,
)