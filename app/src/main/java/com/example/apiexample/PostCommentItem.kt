package com.example.apiexample

data class PostCommentItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)