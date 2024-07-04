package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initToolBar()
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