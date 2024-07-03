package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        navigate()
    }

    private fun navigate() {
        val homeMenu = findViewById<TextView>(R.id.tv_navigation_home)
        val detailMenu = findViewById<TextView>(R.id.tv_navigation_detail)
        val myPageMenu = findViewById<TextView>(R.id.tv_navigation_my_page)

        homeMenu.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
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