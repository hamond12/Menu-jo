package com.example.menujo.data

import com.example.menujo.R

class FoodManager {

    private val foodList: List<FoodInfo> by lazy { initFoodData() }

    var koreanFoodList = getFoodList("koreanFood")
        private set
    var chineseFoodList = getFoodList("chineseFood")
        private set
    var westernFoodList = getFoodList("westernFood")
        private set
    var japaneseFoodList = getFoodList("japaneseFood")
        private set

    var koreanRandomNum = (1..5).random()
    var chineseRandomNum = (1..5).random()
    var westernRandomNum = (1..5).random()
    var japaneseRandomNum = (1..5).random()

    var koreanRandomFood = koreanFoodList.find { it.foodId == koreanRandomNum }
        private set
    var chineseRandomFood = chineseFoodList.find { it.foodId == chineseRandomNum }
        private set
    var westernRandomFood = westernFoodList.find { it.foodId == westernRandomNum }
        private set
    var japaneseRandomFood = japaneseFoodList.find { it.foodId == japaneseRandomNum }
        private set

    var koreanFoodFilteredList = koreanFoodList.filter { it.foodId != koreanRandomNum }
        private set
    var chinesFoodFilteredList = chineseFoodList.filter { it.foodId != chineseRandomNum }
        private set
    var westernFoodListFilteredList = westernFoodList.filter { it.foodId != westernRandomNum }
        private set
    var japaneseFoodListFilteredList = japaneseFoodList.filter { it.foodId != japaneseRandomNum }
        private set

    private fun initFoodData(): MutableList<FoodInfo> {
        return mutableListOf(
            FoodInfo(
                "koreanFood",
                1,
                R.drawable.img_bibimbap,
                "비빔밥",
                "쌀밥에 고기나 나물 등과 여러 가지 양념을 넣어 비벼 먹는 음식",
                listOf("중간맛", "밥", "야채")
            ),
            FoodInfo(
                "koreanFood",
                2,
                R.drawable.img_sundubu,
                "순두부 찌개",
                "순두부를 넣고 양념하여 끓인 찌개",
                listOf("매운맛", "밥")
            ),
            FoodInfo(
                "koreanFood",
                3,
                R.drawable.img_bulgogi,
                "불고기",
                " 여러 동물의 고기를 얇게 썰어 양념으로 재운 뒤 불에 구운 음식",
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "koreanFood",
                4,
                R.drawable.img_japchae,
                "잡채",
                "여러가지 야채들을 기름으로 볶은 뒤 삶은 당면을 간장양념으로 같이 볶은 음식",
                listOf("순한맛", "면", "야채")
            ),
            FoodInfo(
                "koreanFood",
                5,
                R.drawable.img_seafood_pancake,
                "해물파전",
                "해산물을 부쳐서 만든 부드러운 전",
                listOf("순한맛", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                1,
                R.drawable.img_jajangmyeon,
                "짜장면",
                "볶은 춘장과 야채, 고기 등의 재료를 다시 식용유에 볶아 면에 비벼 먹는 음식",
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "chineseFood",
                2,
                R.drawable.img_jjambbong,
                "짬뽕",
                "채소와 해산물, 육류 등을 볶아 육수로 끓여낸 얼큰한 국물에 면을 넣어 만든 음식",
                listOf("매운맛", "면")
            ),
            FoodInfo(
                "chineseFood",
                3,
                R.drawable.img_fired_rice,
                "볶음밥",
                "밥을 다른 재료와 함께 넣고 기름에 볶아 만든 음식",
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "chineseFood",
                4,
                R.drawable.img_tangsuyuk,
                "탕수육",
                "돼지고기에 녹말 반죽을 묻혀서 기름에 튀긴 후, 소스와 함께 먹는 음식",
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "chineseFood",
                5,
                R.drawable.img_mafo_tofu,
                "마파두부",
                "두부를 주재료로, 두반장을 기본 양념으로 하여 만든 음식",
                listOf("중간맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                1,
                R.drawable.img_hamburger,
                "햄버거",
                "패티를 구운 후 다양한 부재료와 함께 빵 사이에 끼워 먹는 음식",
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "westernFood",
                2,
                R.drawable.img_pizza,
                "피자",
                " 밀가루로 반죽에 토마토 소스와 치즈 등의 토핑을 얹어서 구워내는 음식",
                listOf("순한맛", "빵")
            ),
            FoodInfo(
                "westernFood",
                3,
                R.drawable.img_pasta,
                "파스타",
                "밀가루로 만든 면을 사용해, 다양한 소스와 함께 조리되는 음식",
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "westernFood",
                4,
                R.drawable.img_steak,
                "스테이크",
                " 고기 조각을 굽거나 튀긴 음식",
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "westernFood",
                5,
                R.drawable.img_sandwich,
                "샌드위치",
                "식빵 두 장 사이에 재료를 넣어 먹는 음식",
                listOf("순한맛", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                1,
                R.drawable.img_sushi,
                "초밥",
                "식재료를 배합초에 절인 쌀밥 위에 올려 만드는 음식",
                listOf("순한맛", "밥", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                2,
                R.drawable.img_udon,
                "우동",
                "밀가루로 만든 굵은 면발을 사용하여 만든 국수",
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "japaneseFood",
                3,
                R.drawable.img_ramen,
                "라멘",
                "면과 국물로 구성되며, 다양한 재료와 함께 즐겨 먹는 음식",
                listOf("중간맛", "면")
            ),
            FoodInfo(
                "japaneseFood",
                4,
                R.drawable.img_takoyaki,
                "타코야끼",
                "밀가루 반죽에 잘게 썬 문어 등을 넣어 동그랗게 구워내 가쓰오부시와 소스를 뿌려 먹는 음식",
                listOf("중간맛", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                5,
                R.drawable.img_tonkatsu,
                "돈카츠",
                "돼지고기를 저민 뒤 튀김옷을 입혀 튀기는 일본식 음식",
                listOf("순한맛", "고기")
            ),
        )
    }

    fun getFoodList(category: String): List<FoodInfo> {
        return foodList.filter { it.category == category }
    }
}