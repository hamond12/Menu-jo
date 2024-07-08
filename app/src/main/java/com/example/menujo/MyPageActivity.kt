package com.example.menujo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.example.menujo.data.FoodInfo
import com.example.menujo.data.HistoryInfo
import com.example.menujo.data.HistoryManager
import com.example.menujo.data.UserInfo
import com.example.menujo.data.UserManager
import com.google.android.material.appbar.MaterialToolbar

const val EXTRA_STRING_USER_ID = "id"

class MyPageActivity : AppCompatActivity() {

    private lateinit var user: UserInfo
    private val tagStyleManager = TagStyleManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_page)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        setLayout()
    }

    private fun setLayout() {
        initToolbar()
        val userId = intent.getStringExtra(EXTRA_STRING_USER_ID) ?: ""

        if (userId != "") {
            user = UserManager.getUser(userId) ?: UserInfo("", "", "", "", emptyList())
            setUserInfo()
            setHistoryInfo()
        } else {
            Toast.makeText(this, getString(R.string.toast_sign_in_first), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUserInfo() {
        val tvUserName = findViewById<TextView>(R.id.tv_my_page_user_name)
        val tvUserId = findViewById<TextView>(R.id.tv_my_page_user_id)
        val ivProfileImage = findViewById<ImageView>(R.id.iv_profile_image)
        val tvTag01 = findViewById<TextView>(R.id.tv_my_page_tag_1)
        val tvTag02 = findViewById<TextView>(R.id.tv_my_page_tag_2)
        val tvTag03 = findViewById<TextView>(R.id.tv_my_page_tag_3)

        tvUserName.text = user.userName
        tvUserId.text = user.userId
        if (user.profileImageUrl != "") {
            ivProfileImage.apply {
                setPadding(0)
                setImageURI(Uri.parse(user.profileImageUrl))
            }
        }

        val tagCount = user.tags.size

        when (tagCount) {
            1 -> tagStyleManager.setTagOfUser(tvTag01, user, 0)
            2 -> {
                tagStyleManager.setTagOfUser(tvTag01, user, 0)
                tagStyleManager.setTagOfUser(tvTag02, user, 1)
            }
            3 -> {
                tagStyleManager.setTagOfUser(tvTag01, user, 0)
                tagStyleManager.setTagOfUser(tvTag02, user, 1)
                tagStyleManager.setTagOfUser(tvTag03, user, 2)
            }
            else -> return
        }
    }

    private fun setHistoryInfo() {
        val historyList = HistoryManager.getHistoryList(user.userId)

        val ivFood1 = findViewById<ImageView>(R.id.iv_history_food_1)
        val tvFoodName1 = findViewById<TextView>(R.id.tv_history_1_food_name)
        val tvFoodIntroduce1 = findViewById<TextView>(R.id.tv_history_date_1)
        val tvFood1Tag1 = findViewById<TextView>(R.id.tv_history_1_tag_1)
        val tvFood1Tag2 = findViewById<TextView>(R.id.tv_history_1_tag_2)
        val tvFood1Tag3 = findViewById<TextView>(R.id.tv_history_1_tag_3)

        ivFood1.setImageResource(historyList[0].foodImage)
        tvFoodName1.text = getString(historyList[0].foodName)
        tvFoodIntroduce1.text = historyList[0].date
        val tagCount1 = historyList[0].tags.size
        when (tagCount1) {
            1 -> tagStyleManager.setTagOfHistory(tvFood1Tag1, historyList[0], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood1Tag1, historyList[0], 0)
                tagStyleManager.setTagOfHistory(tvFood1Tag2, historyList[0], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood1Tag1, historyList[0], 0)
                tagStyleManager.setTagOfHistory(tvFood1Tag2, historyList[0], 1)
                tagStyleManager.setTagOfHistory(tvFood1Tag3, historyList[0], 2)
            }
            else -> return
        }

        val ivFood2 = findViewById<ImageView>(R.id.iv_history_food_2)
        val tvFoodName2 = findViewById<TextView>(R.id.tv_history_2_food_name)
        val tvFoodIntroduce2 = findViewById<TextView>(R.id.tv_history_2_date)
        val tvFood2Tag1 = findViewById<TextView>(R.id.tv_history_2_tag_1)
        val tvFood2Tag2 = findViewById<TextView>(R.id.tv_history_2_tag_2)
        val tvFood2Tag3 = findViewById<TextView>(R.id.tv_history_2_tag_3)

        ivFood2.setImageResource(historyList[1].foodImage)
        tvFoodName2.text = getString(historyList[1].foodName)
        tvFoodIntroduce2.text = historyList[1].date
        val tagCount2 = historyList[1].tags.size
        when (tagCount2) {
            1 -> tagStyleManager.setTagOfHistory(tvFood2Tag1, historyList[1], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood2Tag1, historyList[1], 0)
                tagStyleManager.setTagOfHistory(tvFood2Tag2, historyList[1], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood2Tag1, historyList[1], 0)
                tagStyleManager.setTagOfHistory(tvFood2Tag2, historyList[1], 1)
                tagStyleManager.setTagOfHistory(tvFood2Tag3, historyList[1], 2)
            }
            else -> return
        }

        val ivFood3 = findViewById<ImageView>(R.id.iv_history_food_3)
        val tvFoodName3 = findViewById<TextView>(R.id.tv_history_3_food_name)
        val tvFoodIntroduce3 = findViewById<TextView>(R.id.tv_history_3_date)
        val tvFood3Tag1 = findViewById<TextView>(R.id.tv_history_3_tag_1)
        val tvFood3Tag2 = findViewById<TextView>(R.id.tv_history_3_tag_2)
        val tvFood3Tag3 = findViewById<TextView>(R.id.tv_history_3_tag_3)

        ivFood3.setImageResource(historyList[2].foodImage)
        tvFoodName3.text = getString(historyList[2].foodName)
        tvFoodIntroduce3.text = historyList[2].date
        val tagCount3 = historyList[2].tags.size
        when (tagCount3) {
            1 -> tagStyleManager.setTagOfHistory(tvFood3Tag1, historyList[2], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood3Tag1, historyList[2], 0)
                tagStyleManager.setTagOfHistory(tvFood3Tag2, historyList[2], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood3Tag1, historyList[2], 0)
                tagStyleManager.setTagOfHistory(tvFood3Tag2, historyList[2], 1)
                tagStyleManager.setTagOfHistory(tvFood3Tag3, historyList[2], 2)
            }
            else -> return
        }

        val ivFood4 = findViewById<ImageView>(R.id.iv_history_food_4)
        val tvFoodName4 = findViewById<TextView>(R.id.tv_history_4_food_name)
        val tvFoodIntroduce4 = findViewById<TextView>(R.id.tv_history_4_date)
        val tvFood4Tag1 = findViewById<TextView>(R.id.tv_history_4_tag_1)
        val tvFood4Tag2 = findViewById<TextView>(R.id.tv_history_4_tag_2)
        val tvFood4Tag3 = findViewById<TextView>(R.id.tv_history_4_tag_3)

        ivFood4.setImageResource(historyList[3].foodImage)
        tvFoodName4.text = getString(historyList[3].foodName)
        tvFoodIntroduce4.text = historyList[3].date
        val tagCount4 = historyList[3].tags.size
        when (tagCount4) {
            1 -> tagStyleManager.setTagOfHistory(tvFood4Tag1, historyList[3], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood4Tag1, historyList[3], 0)
                tagStyleManager.setTagOfHistory(tvFood4Tag2, historyList[3], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood4Tag1, historyList[3], 0)
                tagStyleManager.setTagOfHistory(tvFood4Tag2, historyList[3], 1)
                tagStyleManager.setTagOfHistory(tvFood4Tag3, historyList[3], 2)
            }
            else -> return
        }

        val ivFood5 = findViewById<ImageView>(R.id.iv_history_food_5)
        val tvFoodName5 = findViewById<TextView>(R.id.tv_history_5_food_name)
        val tvFoodIntroduce5 = findViewById<TextView>(R.id.tv_history_5_date)
        val tvFood5Tag1 = findViewById<TextView>(R.id.tv_history_5_tag_1)
        val tvFood5Tag2 = findViewById<TextView>(R.id.tv_history_5_tag_2)
        val tvFood5Tag3 = findViewById<TextView>(R.id.tv_history_5_tag_3)

        ivFood5.setImageResource(historyList[4].foodImage)
        tvFoodName5.text = getString(historyList[4].foodName)
        tvFoodIntroduce5.text = historyList[4].date
        val tagCount5 = historyList[4].tags.size
        when (tagCount5) {
            1 -> tagStyleManager.setTagOfHistory(tvFood5Tag1, historyList[4], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood5Tag1, historyList[4], 0)
                tagStyleManager.setTagOfHistory(tvFood5Tag2, historyList[4], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood5Tag1, historyList[4], 0)
                tagStyleManager.setTagOfHistory(tvFood5Tag2, historyList[4], 1)
                tagStyleManager.setTagOfHistory(tvFood5Tag3, historyList[4], 2)
            }
            else -> return
        }

        val ivFood6 = findViewById<ImageView>(R.id.iv_history_food_6)
        val tvFoodName6 = findViewById<TextView>(R.id.tv_history_6_food_name)
        val tvFoodIntroduce6 = findViewById<TextView>(R.id.tv_history_6_date)
        val tvFood6Tag1 = findViewById<TextView>(R.id.tv_history_6_tag_1)
        val tvFood6Tag2 = findViewById<TextView>(R.id.tv_history_6_tag_2)
        val tvFood6Tag3 = findViewById<TextView>(R.id.tv_history_6_tag_3)

        ivFood6.setImageResource(historyList[5].foodImage)
        tvFoodName6.text = getString(historyList[5].foodName)
        tvFoodIntroduce6.text = historyList[5].date
        val tagCount6 = historyList[5].tags.size
        when (tagCount6) {
            1 -> tagStyleManager.setTagOfHistory(tvFood6Tag1, historyList[5], 0)
            2 -> {
                tagStyleManager.setTagOfHistory(tvFood6Tag1, historyList[5], 0)
                tagStyleManager.setTagOfHistory(tvFood6Tag2, historyList[5], 1)
            }
            3 -> {
                tagStyleManager.setTagOfHistory(tvFood6Tag1, historyList[5], 0)
                tagStyleManager.setTagOfHistory(tvFood6Tag2, historyList[5], 1)
                tagStyleManager.setTagOfHistory(tvFood6Tag3, historyList[5], 2)
            }
            else -> return
        }
    }

    private fun initToolbar(){
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_my_page)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            finish()
            overridePendingTransition(R.anim.none, R.anim.mypage_to_main)
        }
    }

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            this.isEnabled = false
            onBackPressedDispatcher.onBackPressed()
            overridePendingTransition(R.anim.none, R.anim.mypage_to_main)
        }
    }
}