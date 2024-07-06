package com.example.menujo.data

import com.example.menujo.R

object HistoryManager {

    private var historyList = initHistoryData()

    private fun initHistoryData(): MutableList<HistoryInfo> {
        return mutableListOf(
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_sushi,
                R.drawable.img_sushi,
                "2024-05-30",
                listOf("순한맛", "밥", "해산물")
            ),
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_bibimbap,
                R.drawable.img_bibimbap,
                "2024-06-05",
                listOf("중간맛", "밥", "야채")
            ),
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_jjambbong,
                R.drawable.img_jjambbong,
                "2024-06-17",
                listOf("매운맛", "면")
            ),
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_hamburger,
                R.drawable.img_hamburger,
                "2024-06-28",
                listOf("순한맛", "고기", "빵")
            ),
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_tonkatsu,
                R.drawable.img_tonkatsu,
                "2024-07-02",
                listOf("순한맛", "고기")
            ),
            HistoryInfo(
                "aaa123",
                R.string.tv_menu_soft_tofu_stew,
                R.drawable.img_sundubu,
                "2024-07-06",
                listOf("매운맛", "밥")
            ),
        )
    }

    fun getHistoryList(userId: String): List<HistoryInfo> {
        // 히스토리에 유저 아아디까지 담는 로직까지 구현하진 못해서 임시로 모든 히스토리를 반환하도록 구현
        return historyList.sortedByDescending { it.date }
    }
}