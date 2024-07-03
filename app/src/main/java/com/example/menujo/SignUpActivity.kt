package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //뷰연결
        val etName = findViewById<EditText>(R.id.et_signup_name)
        val etId = findViewById<EditText>(R.id.et_signup_id)
        val etPwd = findViewById<EditText>(R.id.et_signup_pwd)
        val btnSignUp = findViewById<Button>(R.id.btn_signup_signup)

        //회원가입데이터
        val nameData = etName.text
        val idData = etId.text
        val pwdData = etPwd.text

        //라디오버튼
//        rgGender.setOnCheckedChangeListener { radioGroup, checkedId ->
//            when (checkedId) {
//                R.id.rb_male -> genderData = "남성"
//                R.id.rb_female -> genderData = "여성"
//            }
//        }

        //회원가입버튼
        btnSignUp.setOnClickListener {
            if (nameData.isBlank() || idData.isBlank() || pwdData.isBlank()) {
                when {
                    nameData.isBlank() -> Toast.makeText(
                        this,
                        "@string/toast_signup_name",
                        Toast.LENGTH_SHORT
                    ).show()

                    idData.isBlank() -> Toast.makeText(
                        this,
                        "@string/toast_signup_id",
                        Toast.LENGTH_SHORT
                    ).show()

                    pwdData.isBlank() -> Toast.makeText(
                        this,
                        "@string/toast_signup_name",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java)
                finish()
            }
        }
    }
}