package com.example.menujo.data

object UserManager {
    private var userList = mutableListOf<UserInfo>()

    fun saveUser(user: UserInfo) {
        userList.add(user)
    }

    fun getUser(userId: String): UserInfo? {
        return userList.find { it.userId == userId }
    }

    fun getUserByName(userName: String): UserInfo? {
        return userList.find { it.userName == userName }
    }
}