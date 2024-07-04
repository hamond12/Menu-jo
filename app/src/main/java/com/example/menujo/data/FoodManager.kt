package com.example.menujo.data

object FoodManager {

    private val foodList = initFoodData()

    private fun initFoodData(): MutableList<FoodInfo> {
        return mutableListOf(
            FoodInfo(
                "koreanFood",
                1,
                null,
                "피자",
                "피자는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "koreanFood",
                2,
                null,
                "햄버거",
                "햄버거는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "koreanFood",
                3,
                null,
                "치킨",
                "치킨은 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "koreanFood",
                4,
                null,
                "햄",
                "햄은 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "koreanFood",
                5,
                null,
                "스테이크",
                "스테이크는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "chineseFood",
                1,
                null,
                "샐러드",
                "샐러드는 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "chineseFood",
                2,
                null,
                "커피",
                "커피는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                3,
                null,
                "케이크",
                "케이크는 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "chineseFood",
                4,
                null,
                "아이스크림",
                "아이스크림은 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                5,
                null,
                "초밥",
                "초밥은 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                1,
                null,
                "라면",
                "라면은 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "westernFood",
                2,
                null,
                "피자",
                "피자는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "westernFood",
                3,
                null,
                "햄버거",
                "햄버거는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                4,
                null,
                "치킨",
                "치킨은 이렇게 생겼습니다.",
                listOf("중간맛", "야채")
            ),
            FoodInfo(
                "westernFood",
                5,
                null,
                "햄",
                "햄은 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                1,
                null,
                "스테이크",
                "스테이크는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                2,
                null,
                "샐러드",
                "샐러드는 이렇게 생겼습니다.",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "japaneseFood",
                3,
                null,
                "커피",
                "커피는 이렇게 생겼습니다.",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                4,
                null,
                "케이크",
                "케이크는 이렇게 생겼습니다.",
                listOf("매운맛", "고기", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                5,
                null,
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