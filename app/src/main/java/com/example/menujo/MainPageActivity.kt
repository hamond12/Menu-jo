package com.example.menujo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.*
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initToolBar()
        initNavigate()
        snackbar()
    }

    private fun snackbar()
    {
        val snackbarBtn = findViewById<Button>(R.id.btn_snackbar)
        snackbarBtn.setOnClickListener {
            val snack1 = Snackbar.make(it, "눌러보삼",Snackbar.LENGTH_LONG)
                .setAction("확인")
            {
                finish()
            }
            snack1.setTextColor(Color.BLACK)
            snack1.setBackgroundTint(Color.WHITE)
            snack1.animationMode = Snackbar.ANIMATION_MODE_FADE //스낵바가 아래에서 위로 올라오는 것과 같은 애니메이션 모드 변경
            snack1.show()
        }
    }



    private fun initImageButton(view:View)
    {
//
//        val koreanFood = findViewById<ImageButton>(R.id.ib_koreanfood)
//        val chineseFood = findViewById<ImageButton>(R.id.ib_chinesefood)
//        val westernFood = findViewById<ImageButton>(R.id.ib_westernfood)
//        val japaneseFood = findViewById<ImageButton>(R.id.ib_japanesefood)
//

        when(view.getId())
        {
            R.id.ib_koreanfood ->
            {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("food","koreanFood")
                startActivity(intent)
            }

            R.id.ib_chinesefood ->
            {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("food","chineseFood")
                startActivity(intent)
            }

            R.id.ib_westernfood ->
            {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("food","westernFood")
                startActivity(intent)
            }

            R.id.ib_japanesefood ->
            {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("food","japaneseFood")
                startActivity(intent)
            }
        }
    }



    private fun initToolBar() {
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


    //네비게이트 바
    private fun initNavigate() {
        val detailMenu = findViewById<TextView>(R.id.tv_navigation_detail)
        val myPageMenu = findViewById<TextView>(R.id.tv_navigation_my_page)

        detailMenu.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        myPageMenu.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }
    }

}