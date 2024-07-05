package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.os.PatternMatcher
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


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

        initToolbar()

        //뷰연결

        val etName = findViewById<EditText>(R.id.et_signup_name)
        val etNameLayout = findViewById<TextInputLayout>(R.id.tv_signup_name_layout)
        val etId = findViewById<EditText>(R.id.et_signup_id)
        val etIdLayout = findViewById<TextInputLayout>(R.id.tv_signup_id_layout)
        val etPwd = findViewById<EditText>(R.id.et_signup_pwd)
        val etPwdLayout = findViewById<TextInputLayout>(R.id.tv_signup_pwd_layout)
        val btnSignUp = findViewById<Button>(R.id.btn_signup_signup)
        val checklist = listOf(
            findViewById<CheckBox>(R.id.cb_meat),
            findViewById<CheckBox>(R.id.cb_seafood),
            findViewById<CheckBox>(R.id.cb_vegetable),
            findViewById<CheckBox>(R.id.cb_rice),
            findViewById<CheckBox>(R.id.cb_noodle),
            findViewById<CheckBox>(R.id.cb_bread),
            findViewById<CheckBox>(R.id.cb_spicy),
            findViewById<CheckBox>(R.id.cb_normal),
            findViewById<CheckBox>(R.id.cb_mild)
        )


        var checkCount = 0

        //회원가입데이터
        val nameData = etName.text
        val idData = etId.text
        val pwdData = etPwd.text

        //체크박스 예외처리
        checklist.forEach { i ->
            i.setOnClickListener {
                if (i.isChecked) {
                    checkCount++
                    if (checkCount == 3) {
                        Toast.makeText(
                            this,
                            getString(R.string.toast_signup_favorite_max3),
                            Toast.LENGTH_SHORT
                        ).show()
                        for (i in checklist) {
                            if (!i.isChecked) i.isEnabled = false
                        }
                    }
                } else {
                    checkCount--
                    for (i in checklist) {
                        if (!i.isChecked) i.isEnabled = true
                    }
                }
            }
        }


        //회원가입버튼, 정규식 사용
        btnSignUp.setOnClickListener {
            val namePattern =  "^([a-zA-Z]*)$"
            val idPattern =  "^([a-zA-Z0-9]*)$"
            val pwdPattern =  "^([0-9]*)$"

            val pattern1 = Pattern.matches(namePattern, nameData)
            val pattern2 = Pattern.matches(idPattern, idData)
            val pattern3 = Pattern.matches(pwdPattern, pwdData)

                    when {
                        nameData.isBlank() -> etNameLayout.error = getString(R.string.toast_signup_name)
                        idData.isBlank() -> etIdLayout.error = getString(R.string.common_set_id)
                        pwdData.isBlank() -> etPwdLayout.error = getString(R.string.common_set_pwd)
                        nameData.length < 2 -> etName.error = getString(R.string.et_signup_name)
                        idData.length < 7 -> etId.error = getString(R.string.et_signup_id)
                        pwdData.length < 7 -> etPwd.error = getString(R.string.et_signup_pwd)
                        pattern1 == false -> etName.error = getString(R.string.et_signup_name_pattern)
                        pattern2 == false -> etId.error = getString(R.string.et_signup_id_pattern)
                        pattern3 == false -> etPwd.error = getString(R.string.et_signup_pwd_pattern)

                        else -> {
                            Toast.makeText(this, getString(R.string.common_signup) + getString(R.string.common_finish), Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, SignInActivity::class.java)
                            intent.putExtra("id", idData.toString())
                            intent.putExtra("password", pwdData.toString())
                            setResult(RESULT_OK, intent)
                            finish()
                        }
                    }
            }
        }

    private fun initToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_signup)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            finish()
            overridePendingTransition(R.anim.none, R.anim.signup_to_signin)
        }
    }

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            this.isEnabled = false
            onBackPressedDispatcher.onBackPressed()
            overridePendingTransition(R.anim.none, R.anim.signup_to_signin)
        }
    }
}