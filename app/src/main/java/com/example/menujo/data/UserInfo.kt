package com.example.menujo.data

data class UserInfo(
    val userId: String,
    val userName: String,
    val userPwd: String,
    val profileImageUrl: String,
    val tags: List<String>
)
