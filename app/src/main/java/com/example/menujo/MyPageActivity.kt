package com.example.menujo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menujo.data.UserInfo
import com.example.menujo.data.UserManager

const val EXTRA_STRING_USER_NAME = "user_name"

class MyPageActivity : AppCompatActivity() {

    private lateinit var user: UserInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUserData()
        setLayout()
    }

    private fun setLayout() {
        // TODO: 유저 이름을 intent로 전달받기
        val userName = intent.getStringExtra(EXTRA_STRING_USER_NAME) ?: "aaaaa"
        user = UserManager.getUserByName(userName)!!
        setUserInfo()
    }

    private fun setUserInfo() {
        val tvUserName = findViewById<TextView>(R.id.tv_my_page_user_name)
        val tvUserId = findViewById<TextView>(R.id.tv_my_page_user_id)
        val tvTag01 = findViewById<TextView>(R.id.tv_my_page_tag_1)
        val tvTag02 = findViewById<TextView>(R.id.tv_my_page_tag_2)
        val tvTag03 = findViewById<TextView>(R.id.tv_my_page_tag_3)

        tvUserName.text = user.userName
        tvUserId.text = user.userId

        val tagCount = user.tags.size

        when (tagCount) {
            1 -> setTag(tvTag01, 0)
            2 -> {
                setTag(tvTag01, 0)
                setTag(tvTag02, 1)
            }
            3 -> {
                setTag(tvTag01, 0)
                setTag(tvTag02, 1)
                setTag(tvTag03, 2)
            }
            else -> return
        }
    }

    private fun setTag(textView: TextView, index: Int) {
        textView.apply {
            visibility = View.VISIBLE
            text = user.tags[index]
            setTextColor(ContextCompat.getColor(context, applyTextColor(user.tags[index])))
            setBackgroundResource(applyBackgroundByTag(user.tags[index]))
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

    private fun initUserData() {
        UserManager.saveUser(UserInfo(
            "aaa123",
            "aaaaa",
            "123123",
            listOf("매운맛", "고기", "해산물")
        ))
        UserManager.saveUser(UserInfo(
            "bbb123",
            "bbbbb",
            "321321",
            listOf("매운맛", "밥")
        ))
    }
}