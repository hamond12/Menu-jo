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
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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

        Log.d("MyPageActivity", user.profileImageUrl)

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
            else -> R.drawable.bg_tag_white
        }
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