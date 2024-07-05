package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menujo.data.FoodInfo
import com.example.menujo.data.FoodManager

const val RANDOM_IMAGE_COUNT = 5

class FoodListActivity : AppCompatActivity() {

    private lateinit var foodList: List<FoodInfo>
    private lateinit var randomFood: FoodInfo
    private lateinit var filteredFoodList : List<FoodInfo>

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
                foodList = FoodManager.koreanFoodList
                randomFood = FoodManager.koreanRandomFood!!
                filteredFoodList = FoodManager.koreanFoodFilteredList
            }
            "chineseFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_chinesefood))
                foodList = FoodManager.chineseFoodList
                randomFood = FoodManager.chineseRandomFood!!
                filteredFoodList = FoodManager.chinesFoodFilteredList
            }
            "westernFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_westernfood))
                foodList = FoodManager.westernFoodList
                randomFood = FoodManager.westernRandomFood!!
                filteredFoodList = FoodManager.westernFoodListFilteredList
            }
            "japaneseFood" -> {
                tvTitleList.text = getString(R.string.detail_menu_list_title, getString(R.string.main_japanesefood))
                foodList = FoodManager.japaneseFoodList
                randomFood = FoodManager.japaneseRandomFood!!
                filteredFoodList = FoodManager.japaneseFoodListFilteredList
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
        val recommendImg = findViewById<ImageView>(R.id.iv_recommend_food)
        val tvRecommendMenuName = findViewById<TextView>(R.id.tv_recommend_menu_name)
        val tvRecommendMenuIntroduce = findViewById<TextView>(R.id.tv_recommend_menu_introduce)
        val tvDetailTag1 = findViewById<TextView>(R.id.tv_detail_tag_1)
        val tvDetailTag2 = findViewById<TextView>(R.id.tv_detail_tag_2)
        val tvDetailTag3 = findViewById<TextView>(R.id.tv_detail_tag_3)

        recommendImg.setImageResource(randomFood.image)
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
        val ivFood1 = findViewById<ImageView>(R.id.iv_food_1)
        val tvFoodName1 = findViewById<TextView>(R.id.tv_food_name_1)
        val tvFoodIntroduce1 = findViewById<TextView>(R.id.tv_food_introduce_1)
        val tvFood1Tag1 = findViewById<TextView>(R.id.tv_food_1_tag_1)
        val tvFood1Tag2 = findViewById<TextView>(R.id.tv_food_1_tag_2)
        val tvFood1Tag3 = findViewById<TextView>(R.id.tv_food_1_tag_3)

        ivFood1.setImageResource(filteredFoodList[0].image)
        tvFoodName1.text = filteredFoodList[0].name
        tvFoodIntroduce1.text = filteredFoodList[0].introduce
        val tagCount1 = filteredFoodList[0].tags.size
        when (tagCount1) {
            1 -> setTag(tvFood1Tag1, filteredFoodList[0], 0)
            2 -> {
                setTag(tvFood1Tag1, filteredFoodList[0], 0)
                setTag(tvFood1Tag2, filteredFoodList[0], 1)
            }
            3 -> {
                setTag(tvFood1Tag1, filteredFoodList[0], 0)
                setTag(tvFood1Tag2, filteredFoodList[0], 1)
                setTag(tvFood1Tag3, filteredFoodList[0], 2)
            }
            else -> return
        }

        val ivFood2 = findViewById<ImageView>(R.id.iv_food_2)
        val tvFoodName2 = findViewById<TextView>(R.id.tv_food_name_2)
        val tvFoodIntroduce2 = findViewById<TextView>(R.id.tv_food_introduce_2)
        val tvFood2Tag1 = findViewById<TextView>(R.id.tv_food_2_tag_1)
        val tvFood2Tag2 = findViewById<TextView>(R.id.tv_food_2_tag_2)
        val tvFood2Tag3 = findViewById<TextView>(R.id.tv_food_2_tag_3)

        ivFood2.setImageResource(filteredFoodList[1].image)
        tvFoodName2.text = filteredFoodList[1].name
        tvFoodIntroduce2.text = filteredFoodList[1].introduce
        val tagCount2 = filteredFoodList[1].tags.size
        when (tagCount2) {
            1 -> setTag(tvFood2Tag1, filteredFoodList[1], 0)
            2 -> {
                setTag(tvFood2Tag1, filteredFoodList[1], 0)
                setTag(tvFood2Tag2, filteredFoodList[1], 1)
            }
            3 -> {
                setTag(tvFood2Tag1, filteredFoodList[1], 0)
                setTag(tvFood2Tag2, filteredFoodList[1], 1)
                setTag(tvFood2Tag3, filteredFoodList[1], 2)
            }
            else -> return
        }

        val ivFood3 = findViewById<ImageView>(R.id.iv_food_3)
        val tvFoodName3 = findViewById<TextView>(R.id.tv_food_name_3)
        val tvFoodIntroduce3 = findViewById<TextView>(R.id.tv_food_introduce_3)
        val tvFood3Tag1 = findViewById<TextView>(R.id.tv_food_3_tag_1)
        val tvFood3Tag2 = findViewById<TextView>(R.id.tv_food_3_tag_2)
        val tvFood3Tag3 = findViewById<TextView>(R.id.tv_food_3_tag_3)

        ivFood3.setImageResource(filteredFoodList[2].image)
        tvFoodName3.text = filteredFoodList[2].name
        tvFoodIntroduce3.text = filteredFoodList[2].introduce
        val tagCount3 = filteredFoodList[2].tags.size
        when (tagCount3) {
            1 -> setTag(tvFood3Tag1, filteredFoodList[2], 0)
            2 -> {
                setTag(tvFood3Tag1, filteredFoodList[2], 0)
                setTag(tvFood3Tag2, filteredFoodList[2], 1)
            }
            3 -> {
                setTag(tvFood3Tag1, filteredFoodList[2], 0)
                setTag(tvFood3Tag2, filteredFoodList[2], 1)
                setTag(tvFood3Tag3, filteredFoodList[2], 2)
            }
            else -> return
        }

        val ivFood4 = findViewById<ImageView>(R.id.iv_food_4)
        val tvFoodName4 = findViewById<TextView>(R.id.tv_food_name_4)
        val tvFoodIntroduce4 = findViewById<TextView>(R.id.tv_food_introduce_4)
        val tvFood4Tag1 = findViewById<TextView>(R.id.tv_food_4_tag_1)
        val tvFood4Tag2 = findViewById<TextView>(R.id.tv_food_4_tag_2)
        val tvFood4Tag3 = findViewById<TextView>(R.id.tv_food_4_tag_3)

        ivFood4.setImageResource(filteredFoodList[3].image)
        tvFoodName4.text = filteredFoodList[3].name
        tvFoodIntroduce4.text = filteredFoodList[3].introduce
        val tagCount4 = filteredFoodList[3].tags.size
        when (tagCount4) {
            1 -> setTag(tvFood4Tag1, filteredFoodList[3], 0)
            2 -> {
                setTag(tvFood4Tag1, filteredFoodList[3], 0)
                setTag(tvFood4Tag2, filteredFoodList[3], 1)
            }
            3 -> {
                setTag(tvFood4Tag1, filteredFoodList[3], 0)
                setTag(tvFood4Tag2, filteredFoodList[3], 1)
                setTag(tvFood4Tag3, filteredFoodList[3], 2)
            }
            else -> return
        }
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