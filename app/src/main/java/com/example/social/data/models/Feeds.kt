package com.example.social.data.models

data class Feeds(
    val description: String,
    val post: List<String>,
    val userImage: String,
    val userName: String,
    val spanCount: Int,
)