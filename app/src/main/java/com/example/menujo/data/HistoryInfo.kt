package com.example.menujo.data

data class HistoryInfo(
    val userId: String,
    val foodName: Int,
    val foodImage: Int,
    val date: String,
    val tags: List<String>
)
