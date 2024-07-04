package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menujo.data.FoodInfo
import com.example.menujo.data.FoodManager
import kotlin.random.Random

const val RANDOM_IMAGE_COUNT = 5

class FoodListActivity : AppCompatActivity() {

    private lateinit var foodList: List<FoodInfo>
    private var randomNum = 0
    private lateinit var randomFood: FoodInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initToolBar()
        setLayout()
    }

    private fun setLayout() {
        val category = intent.getStringExtra("food")
        val tvTitleList = findViewById<TextView>(R.id.tv_title_list)
        when (category) {
            "koreanFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_koreanfood))
                foodList = FoodManager.getFoodList("koreanFood")
            }
            "chineseFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_chinesefood))
                foodList = FoodManager.getFoodList("chineseFood")
            }
            "westernFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_westernfood))
                foodList = FoodManager.getFoodList("westernFood")
            }
            "japaneseFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_japanesefood))
                foodList = FoodManager.getFoodList("japaneseFood")
            }
            else -> {
                foodList = emptyList()
            }
        }
        if (foodList.isNotEmpty()) {
            setRecommendFoodInfo()
            setFoodListInfo()
        }
    }

    private fun setRecommendFoodInfo() {
        val random = Random
        randomNum = random.nextInt(RANDOM_IMAGE_COUNT) + 1

        randomFood = foodList[randomNum - 1]

        val recommendImg = findViewById<ImageView>(R.id.iv_recommend_food)
        val tvRecommendMenuName = findViewById<TextView>(R.id.tv_recommend_menu_name)
        val tvRecommendMenuIntroduce = findViewById<TextView>(R.id.tv_recommend_menu_introduce)
        val tvDetailTag1 = findViewById<TextView>(R.id.tv_detail_tag_1)
        val tvDetailTag2 = findViewById<TextView>(R.id.tv_detail_tag_2)
        val tvDetailTag3 = findViewById<TextView>(R.id.tv_detail_tag_3)

        recommendImg.setImageResource(R.drawable.ic_jjambbong)
        tvRecommendMenuName.text = randomFood.name
        tvRecommendMenuIntroduce.text = randomFood.introduce

        val tagCount = randomFood.tags.size

        when (tagCount) {
            1 -> setTag(tvDetailTag1, randomFood, 0)
            2 -> {
                setTag(tvDetailTag1, randomFood, 0)
                setTag(tvDetailTag2, randomFood, 1)
            }
            3 -> {
                setTag(tvDetailTag1, randomFood, 0)
                setTag(tvDetailTag2, randomFood, 1)
                setTag(tvDetailTag3, randomFood, 2)
            }
            else -> return
        }
    }

    private fun setFoodListInfo() {
        val filteredList = foodList.filter { it.foodId != randomFood.foodId }

        val ivFood1 = findViewById<ImageView>(R.id.iv_food_1)
        val tvFoodName1 = findViewById<TextView>(R.id.tv_food_name_1)
        val tvFoodIntroduce1 = findViewById<TextView>(R.id.tv_food_introduce_1)
        val tvFood1Tag1 = findViewById<TextView>(R.id.tv_food_1_tag_1)
        val tvFood1Tag2 = findViewById<TextView>(R.id.tv_food_1_tag_2)
        val tvFood1Tag3 = findViewById<TextView>(R.id.tv_food_1_tag_3)

        ivFood1.setImageResource(R.drawable.ic_jjambbong)
        tvFoodName1.text = filteredList[0].name
        tvFoodIntroduce1.text = filteredList[0].introduce
        val tagCount1 = filteredList[0].tags.size
        when (tagCount1) {
            1 -> setTag(tvFood1Tag1, filteredList[0], 0)
            2 -> {
                setTag(tvFood1Tag1, filteredList[0], 0)
                setTag(tvFood1Tag2, filteredList[0], 1)
            }
            3 -> {
                setTag(tvFood1Tag1, filteredList[0], 0)
                setTag(tvFood1Tag2, filteredList[0], 1)
                setTag(tvFood1Tag3, filteredList[0], 2)
            }
            else -> return
        }

        val ivFood2 = findViewById<ImageView>(R.id.iv_food_2)
        val tvFoodName2 = findViewById<TextView>(R.id.tv_food_name_2)
        val tvFoodIntroduce2 = findViewById<TextView>(R.id.tv_food_introduce_2)
        val tvFood2Tag1 = findViewById<TextView>(R.id.tv_food_2_tag_1)
        val tvFood2Tag2 = findViewById<TextView>(R.id.tv_food_2_tag_2)
        val tvFood2Tag3 = findViewById<TextView>(R.id.tv_food_2_tag_3)

        ivFood2.setImageResource(R.drawable.ic_jjambbong)
        tvFoodName2.text = filteredList[1].name
        tvFoodIntroduce2.text = filteredList[1].introduce
        val tagCount2 = filteredList[1].tags.size
        when (tagCount2) {
            1 -> setTag(tvFood2Tag1, filteredList[1], 0)
            2 -> {
                setTag(tvFood2Tag1, filteredList[1], 0)
                setTag(tvFood2Tag2, filteredList[1], 1)
            }
            3 -> {
                setTag(tvFood2Tag1, filteredList[1], 0)
                setTag(tvFood2Tag2, filteredList[1], 1)
                setTag(tvFood2Tag3, filteredList[1], 2)
            }
            else -> return
        }

        val ivFood3 = findViewById<ImageView>(R.id.iv_food_3)
        val tvFoodName3 = findViewById<TextView>(R.id.tv_food_name_3)
        val tvFoodIntroduce3 = findViewById<TextView>(R.id.tv_food_introduce_3)
        val tvFood3Tag1 = findViewById<TextView>(R.id.tv_food_3_tag_1)
        val tvFood3Tag2 = findViewById<TextView>(R.id.tv_food_3_tag_2)
        val tvFood3Tag3 = findViewById<TextView>(R.id.tv_food_3_tag_3)

        ivFood3.setImageResource(R.drawable.ic_jjambbong)
        tvFoodName3.text = filteredList[2].name
        tvFoodIntroduce3.text = filteredList[2].introduce
        val tagCount3 = filteredList[2].tags.size
        when (tagCount3) {
            1 -> setTag(tvFood3Tag1, filteredList[2], 0)
            2 -> {
                setTag(tvFood3Tag1, filteredList[2], 0)
                setTag(tvFood3Tag2, filteredList[2], 1)
            }
            3 -> {
                setTag(tvFood3Tag1, filteredList[2], 0)
                setTag(tvFood3Tag2, filteredList[2], 1)
                setTag(tvFood3Tag3, filteredList[2], 2)
            }
            else -> return
        }

        val ivFood4 = findViewById<ImageView>(R.id.iv_food_4)
        val tvFoodName4 = findViewById<TextView>(R.id.tv_food_name_4)
        val tvFoodIntroduce4 = findViewById<TextView>(R.id.tv_food_introduce_4)
        val tvFood4Tag1 = findViewById<TextView>(R.id.tv_food_4_tag_1)
        val tvFood4Tag2 = findViewById<TextView>(R.id.tv_food_4_tag_2)
        val tvFood4Tag3 = findViewById<TextView>(R.id.tv_food_4_tag_3)

        ivFood4.setImageResource(R.drawable.ic_jjambbong)
        tvFoodName4.text = filteredList[3].name
        tvFoodIntroduce4.text = filteredList[3].introduce
        val tagCount4 = filteredList[3].tags.size
        when (tagCount4) {
            1 -> setTag(tvFood4Tag1, filteredList[3], 0)
            2 -> {
                setTag(tvFood4Tag1, filteredList[3], 0)
                setTag(tvFood4Tag2, filteredList[3], 1)
            }
            3 -> {
                setTag(tvFood4Tag1, filteredList[3], 0)
                setTag(tvFood4Tag2, filteredList[3], 1)
                setTag(tvFood4Tag3, filteredList[3], 2)
            }
            else -> return
        }

//        val ivFood5 = findViewById<ImageView>(R.id.iv_food_5)
//        val tvFoodName5 = findViewById<TextView>(R.id.tv_food_name_5)
//        val tvFoodIntroduce5 = findViewById<TextView>(R.id.tv_food_introduce_5)
//        val tvFood5Tag1 = findViewById<TextView>(R.id.tv_food_5_tag_1)
//        val tvFood5Tag2 = findViewById<TextView>(R.id.tv_food_5_tag_2)
//        val tvFood5Tag3 = findViewById<TextView>(R.id.tv_food_5_tag_3)
//
//        ivFood5.setImageResource(R.drawable.ic_jjambbong)
//        tvFoodName5.text = foodList[4].name
//        tvFoodIntroduce5.text = foodList[4].introduce
//        val tagCount5 = foodList[4].tags.size
//        when (tagCount5) {
//            1 -> setTag(tvFood5Tag1, foodList[4],0)
//            2 -> {
//                setTag(tvFood5Tag1, foodList[4], 0)
//                setTag(tvFood5Tag2, foodList[4], 1)
//            }
//            3 -> {
//                setTag(tvFood5Tag1, foodList[4], 0)
//                setTag(tvFood5Tag2, foodList[4], 1)
//                setTag(tvFood5Tag3, foodList[4], 2)
//            }
//            else -> return
//        }

//        // 랜덤으로 추천된 음식 Visibility 설정
//        val groupRandomFoodInfo = when (randomNum) {
//            1 -> findViewById<Group>(R.id.group_food_1)
//            2 -> findViewById<Group>(R.id.group_food_2)
//            3 -> findViewById<Group>(R.id.group_food_3)
//            4 -> findViewById<Group>(R.id.group_food_4)
//            5 -> findViewById<Group>(R.id.group_food_5)
//            else -> return
//        }
//        groupRandomFoodInfo.visibility = View.GONE
    }

    private fun setTag(textView: TextView, food: FoodInfo, index: Int) {
        textView.apply {
            visibility = View.VISIBLE
            text = food.tags[index]
            setTextColor(ContextCompat.getColor(context, applyTextColor(food.tags[index])))
            setBackgroundResource(applyBackgroundByTag(food.tags[index]))
        }
    }

    private fun applyTextColor(tag: String): Int {
        return when (tag) {
            "고기" -> R.color.white
            "해산물" -> R.color.black
            "밥" -> R.color.black
            "면" -> R.color.black
            "빵" -> R.color.white
            "매운맛" -> R.color.white
            "중간맛" -> R.color.white
            "순한맛" -> R.color.black
            "야채" -> R.color.white
            "과일" -> R.color.black
            else -> R.color.white
        }
    }

    private fun applyBackgroundByTag(tag: String): Int {
        return when (tag) {
            "고기" -> R.drawable.bg_tag_dark_brown
            "해산물" -> R.drawable.bg_tag_skyblue
            "밥" -> R.drawable.bg_tag_white
            "면" -> R.drawable.bg_tag_basic
            "빵" -> R.drawable.bg_tag_brown
            "매운맛" -> R.drawable.bg_tag_red
            "중간맛" -> R.drawable.bg_tag_orange
            "순한맛" -> R.drawable.bg_tag_yellow
            "야채" -> R.drawable.bg_tag_green
            "과일" -> R.drawable.bg_tag_pink
            else -> R.drawable.bg_tag_white
        }
    }



    //date class

    private fun initToolBar() {
        val leftIcon = findViewById<ImageView>(R.id.iv_left_icon)

        leftIcon.setImageResource(R.drawable.back)
        leftIcon.setOnClickListener {
            finish()
        }

        val accountIcon = findViewById<ImageView>(R.id.iv_right_icon)
        val userName = findViewById<TextView>(R.id.tv_user_name)
        val loginBtn = findViewById<Button>(R.id.btn_login)

        // 로그인 확인 조건문(임시)
        if(false) {
            loginBtn.setVisibility(View.GONE);
        }else{
            accountIcon.setVisibility(View.GONE)
            userName.setVisibility(View.GONE)
        }

        loginBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}