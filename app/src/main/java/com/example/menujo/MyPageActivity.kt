package com.example.menujo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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
import com.example.menujo.data.UserInfo
import com.example.menujo.data.UserManager
import com.google.android.material.appbar.MaterialToolbar

const val EXTRA_STRING_USER_ID = "id"
const val EXTRA_STRING_USER_NAME = "name"

class MyPageActivity : AppCompatActivity() {

    private lateinit var user: UserInfo

    private val tagToStringResourceMap = mapOf(
        "고기" to R.string.cb_meat,
        "meat" to R.string.cb_meat,
        "해산물" to R.string.cb_seafood,
        "seafood" to R.string.cb_seafood,
        "밥" to R.string.cb_rice,
        "rice" to R.string.cb_rice,
        "면" to R.string.cb_noodle,
        "noodle" to R.string.cb_noodle,
        "빵" to R.string.cb_bread,
        "bread" to R.string.cb_bread,
        "매운맛" to R.string.cb_spicy,
        "spicy" to R.string.cb_spicy,
        "중간맛" to R.string.cb_normal,
        "normal" to R.string.cb_normal,
        "순한맛" to R.string.cb_mild,
        "mild" to R.string.cb_mild,
        "야채" to R.string.cb_vegetable,
        "vegetable" to R.string.cb_vegetable
    )

    private val tagToColorResourceMap = mapOf(
        "고기" to R.color.white,
        "meat" to R.color.white,
        "해산물" to R.color.black,
        "seafood" to R.color.black,
        "밥" to R.color.black,
        "rice" to R.color.black,
        "면" to R.color.black,
        "noodle" to R.color.black,
        "빵" to R.color.white,
        "bread" to R.color.white,
        "매운맛" to R.color.white,
        "spicy" to R.color.white,
        "중간맛" to R.color.white,
        "normal" to R.color.white,
        "순한맛" to R.color.black,
        "mild" to R.color.black,
        "야채" to R.color.white,
        "vegetable" to R.color.white
    )

    private fun tagToDrawableResourceMap(tag: String): Int {
        return when (tag) {
            "고기" -> R.drawable.bg_tag_dark_brown
            "meat" -> R.drawable.bg_tag_dark_brown
            "해산물" -> R.drawable.bg_tag_skyblue
            "seafood" -> R.drawable.bg_tag_skyblue
            "밥" -> R.drawable.bg_tag_white
            "rice" -> R.drawable.bg_tag_white
            "면" -> R.drawable.bg_tag_basic
            "noodle" -> R.drawable.bg_tag_basic
            "빵" -> R.drawable.bg_tag_brown
            "bread" -> R.drawable.bg_tag_brown
            "매운맛" -> R.drawable.bg_tag_red
            "spicy" -> R.drawable.bg_tag_red
            "중간맛" -> R.drawable.bg_tag_orange
            "normal" -> R.drawable.bg_tag_orange
            "순한맛" -> R.drawable.bg_tag_yellow
            "mild" -> R.drawable.bg_tag_yellow
            "야채" -> R.drawable.bg_tag_green
            "vegetable" -> R.drawable.bg_tag_green
            else -> R.drawable.bg_tag_white
        }
    }

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
        signOut()
    }

    private fun setLayout() {
        initToolbar()
        // TODO: 유저 이름을 intent로 전달받기
        val userId = intent.getStringExtra(EXTRA_STRING_USER_ID) ?: ""

        if (userId != "") {
            user = UserManager.getUser(userId) ?: UserInfo("", "", "", "", emptyList())
            setUserInfo()
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
        } else {
            findViewById<TextView>(R.id.tv_no_image).visibility = View.VISIBLE
        }

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
            text = applyText(user.tags[index])
            setTextColor(ContextCompat.getColor(context, applyTextColor(user.tags[index])))
            setBackgroundResource(applyBackgroundByTag(user.tags[index]))
        }
    }

    private fun applyText(tag: String): String {
        val resourceId = tagToStringResourceMap[tag.lowercase()]
        return if (resourceId != null) getString(resourceId) else ""
    }

    private fun applyTextColor(tag: String): Int {
        return tagToColorResourceMap[tag.lowercase()] ?: R.color.black
    }

    private fun applyBackgroundByTag(tag: String): Int {
        return tagToDrawableResourceMap(tag.lowercase())
    }

    private fun signOut() {
        val btnNavigateToHome = findViewById<Button>(R.id.btn_navigate_to_home)
        btnNavigateToHome.setOnClickListener {
            val intent = Intent(this, MainPageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra(EXTRA_STRING_USER_ID, user.userId)
            intent.putExtra(EXTRA_STRING_USER_NAME, user.userName)
            startActivity(intent)
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