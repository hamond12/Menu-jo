package com.example.menujo.data

import com.example.menujo.R

object FoodManager {

    private val foodList = initFoodData()

    private fun initFoodData(): MutableList<FoodInfo> {
        return mutableListOf(
            FoodInfo(
                "koreanFood",
                1,
                R.drawable.img_bibimbap,
                "피자",
                "피자는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "koreanFood",
                2,
                R.drawable.img_bibimbap,
                "햄버거",
                "햄버거는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "koreanFood",
                3,
                R.drawable.img_bibimbap,
                "치킨",
                "치킨은 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "koreanFood",
                4,
                R.drawable.img_jjimdak,
                "햄",
                "햄은 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "koreanFood",
                5,
                R.drawable.img_jjimdak,
                "스테이크",
                "스테이크는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "chineseFood",
                1,
                R.drawable.ic_jjambbong,
                "샐러드",
                "샐러드는 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "chineseFood",
                2,
                R.drawable.ic_jajangmyeon,
                "커피",
                "커피는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                3,
                R.drawable.ic_jajangmyeon,
                "케이크",
                "케이크는 이렇게 생겼습니다.",
                listOf("중간맛")
            ),
            FoodInfo(
                "chineseFood",
                4,
                R.drawable.ic_jajangmyeon,
                "아이스크림",
                "아이스크림은 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                5,
                R.drawable.ic_jajangmyeon,
                "초밥",
                "초밥은 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                1,
                R.drawable.img_aglio_olio,
                "라면",
                "라면은 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "westernFood",
                2,
                R.drawable.img_aglio_olio,
                "피자",
                "피자는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "westernFood",
                3,
                R.drawable.img_aglio_olio,
                "햄버거",
                "햄버거는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                4,
                R.drawable.img_pizza,
                "치킨",
                "치킨은 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "westernFood",
                5,
                R.drawable.img_pizza,
                "햄",
                "햄은 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                1,
                R.drawable.img_ramen,
                "스테이크",
                "스테이크는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                2,
                R.drawable.img_ramen,
                "샐러드",
                "샐러드는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "japaneseFood",
                3,
                R.drawable.img_ramen,
                "커피",
                "커피는 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                4,
                R.drawable.img_sushi,
                "케이크",
                "케이크는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                5,
                R.drawable.img_sushi,
                "아이스크림",
                "아이스크림은 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
        )
    }

    fun getFoodList(category: String): List<FoodInfo> {
        return foodList.filter { it.category == category }
    }
}