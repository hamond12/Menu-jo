package com.example.menujo.data

object UserManager {
    private var userList = initUserData()

    private fun initUserData(): MutableList<UserInfo> {
        return mutableListOf(
            UserInfo(
                "aaa123",
                "aaaaa",
                "1111111",
                "",
                listOf("매운맛", "고기", "해산물")
            ),
            UserInfo(
                "bbb123",
                "bbbbb",
                "2222222",
                "",
                listOf("순한맛", "밥")
            ),
            UserInfo(
                "ccc123",
                "ccccc",
                "3333333",
                "",
                listOf("중간맛", "야채")
            ),
            UserInfo(
                "ddd123",
                "ddddd",
                "4444444",
                "",
                listOf("순한맛", "고기", "빵")
            ),
            UserInfo(
                "eee123",
                "eeeee",
                "5555555",
                "",
                listOf("매운맛", "면", "해산물")
            ),
        )
    }

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