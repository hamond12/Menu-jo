package com.example.menujo

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //뷰연결
    val etId = findViewById<EditText>(R.id.et_signin_id)
    val etPwd = findViewById<EditText>(R.id.et_signin_pwd)



}