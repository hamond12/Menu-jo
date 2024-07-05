package com.example.menujo.data

import android.graphics.drawable.Drawable

data class FoodInfo(
    val category: String,
    val foodId: Int,
    val image: Int,
    val name: String,
    val introduce: String,
    val tags: List<String>,
)
