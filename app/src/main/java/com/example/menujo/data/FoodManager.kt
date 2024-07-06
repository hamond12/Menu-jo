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

    private var koreanRandomNum = (1..5).random()
    private var chineseRandomNum = (1..5).random()
    private var westernRandomNum = (1..5).random()
    private var japaneseRandomNum = (1..5).random()

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
                R.string.tv_menu_bibimbap,
                R.string.tv_menu_intro_bibimbap,
                listOf("중간맛", "밥", "야채")
            ),
            FoodInfo(
                "koreanFood",
                2,
                R.drawable.img_sundubu,
                R.string.tv_menu_soft_tofu_stew,
                R.string.tv_menu_intro_soft_tofu_stew,
                listOf("매운맛", "밥")
            ),
            FoodInfo(
                "koreanFood",
                3,
                R.drawable.img_bulgogi,
                R.string.tv_menu_bulgogi,
                R.string.tv_menu_intro_bulgogi,
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "koreanFood",
                4,
                R.drawable.img_japchae,
                R.string.tv_menu_japchae,
                R.string.tv_menu_intro_japchae,
                listOf("순한맛", "면", "야채")
            ),
            FoodInfo(
                "koreanFood",
                5,
                R.drawable.img_seafood_pancake,
                R.string.tv_menu_seafood_pancake,
                R.string.tv_menu_intro_eafood_pancake,
                listOf("순한맛", "해산물")
            ),
            FoodInfo(
                "chineseFood",
                1,
                R.drawable.img_jajangmyeon,
                R.string.tv_menu_jajangmyeon,
                R.string.tv_menu_intro_jajangmyeon,
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "chineseFood",
                2,
                R.drawable.img_jjambbong,
                R.string.tv_menu_jjambbong,
                R.string.tv_menu_intro_jjambbong,
                listOf("매운맛", "면")
            ),
            FoodInfo(
                "chineseFood",
                3,
                R.drawable.img_fired_rice,
                R.string.tv_menu_egg_fried_rice,
                R.string.tv_menu_intro_egg_fried_rice,
                listOf("순한맛", "밥")
            ),
            FoodInfo(
                "chineseFood",
                4,
                R.drawable.img_tangsuyuk,
                R.string.tv_menu_sweet_and_sour_pork,
                R.string.tv_menu_intro_sweet_and_sour_pork,
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "chineseFood",
                5,
                R.drawable.img_mafo_tofu,
                R.string.tv_menu_mapo_tofu,
                R.string.tv_menu_intro_mapo_tofu,
                listOf("중간맛", "밥")
            ),
            FoodInfo(
                "westernFood",
                1,
                R.drawable.img_hamburger,
                R.string.tv_menu_hamburger,
                R.string.tv_menu_intro_hamburger,
                listOf("순한맛", "고기", "빵")
            ),
            FoodInfo(
                "westernFood",
                2,
                R.drawable.img_pizza,
                R.string.tv_menu_pizza,
                R.string.tv_menu_intro_pizza,
                listOf("순한맛", "빵")
            ),
            FoodInfo(
                "westernFood",
                3,
                R.drawable.img_pasta,
                R.string.tv_menu_pasta,
                R.string.tv_menu_intro_pasta,
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "westernFood",
                4,
                R.drawable.img_steak,
                R.string.tv_menu_steak,
                R.string.tv_menu_intro_steak,
                listOf("순한맛", "고기")
            ),
            FoodInfo(
                "westernFood",
                5,
                R.drawable.img_sandwich,
                R.string.tv_menu_sandwich,
                R.string.tv_menu_intro_sandwich,
                listOf("순한맛", "빵")
            ),
            FoodInfo(
                "japaneseFood",
                1,
                R.drawable.img_sushi,
                R.string.tv_menu_sushi,
                R.string.tv_menu_intro_sushi,
                listOf("순한맛", "밥", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                2,
                R.drawable.img_udon,
                R.string.tv_menu_udon,
                R.string.tv_menu_intro_udon,
                listOf("순한맛", "면")
            ),
            FoodInfo(
                "japaneseFood",
                3,
                R.drawable.img_ramen,
                R.string.tv_menu_ramen,
                R.string.tv_menu_intro_ramen,
                listOf("중간맛", "면")
            ),
            FoodInfo(
                "japaneseFood",
                4,
                R.drawable.img_takoyaki,
                R.string.tv_menu_takoyaki,
                R.string.tv_menu_intro_takoyaki,
                listOf("중간맛", "해산물")
            ),
            FoodInfo(
                "japaneseFood",
                5,
                R.drawable.img_tonkatsu,
                R.string.tv_menu_tonkatsu,
                R.string.tv_menu_intro_tonkatsu,
                listOf("순한맛", "고기")
            ),
        )
    }

    fun getFoodList(category: String): List<FoodInfo> {
        return foodList.filter { it.category == category }
    }
}