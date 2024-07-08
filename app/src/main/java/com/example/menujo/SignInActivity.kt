package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.menujo.data.UserInfo
import com.example.menujo.data.UserManager
import com.google.android.material.appbar.MaterialToolbar

class SignInActivity : AppCompatActivity() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var userData: UserInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        initToolbar()

        //뷰연결
        val etId = findViewById<EditText>(R.id.et_signin_id)
        val etPwd = findViewById<EditText>(R.id.et_signin_pwd)
        val btnSignIn = findViewById<Button>(R.id.btn_signin_signin)
        val btnSignUp = findViewById<Button>(R.id.btn_signin_signup)

        //로그인버튼
        btnSignIn.setOnClickListener {
            val idData = etId.text
            val pwdData = etPwd.text
            if (idData.isBlank() || pwdData.isBlank()) {
                var toastSignIn = ""
                when {
                    idData.isBlank() -> toastSignIn = getString(R.string.common_set_id)
                    pwdData.isBlank() -> toastSignIn = getString(R.string.common_set_pwd)
                }
                Toast.makeText(this, "$toastSignIn", Toast.LENGTH_SHORT).show()
            } else {
                if (UserManager.getUser(idData.toString()) == null) {
                    Toast.makeText(
                        this,
                        getString(R.string.toast_signin_non_user),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                if (UserManager.getUser(idData.toString())?.userPwd != pwdData.toString()) {
                    Toast.makeText(
                        this,
                        getString(R.string.toast_signin_non_user),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                Toast.makeText(
                    this,
                    getString(R.string.common_signin) + getString(R.string.common_finish),
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, MainPageActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("id", userData.userId)
                intent.putExtra("name", userData.userName)
                startActivity(intent)
                overridePendingTransition(R.anim.siginin_to_main, R.anim.none)
            }

        }

        //회원가입버튼
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
            overridePendingTransition(R.anim.signin_to_signup, R.anim.none)
        }

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    userData = result.data?.getParcelableExtra("userData") ?: UserInfo(
                        "", "", "", "",
                        emptyList()
                    )
                    etId.setText(userData.userId)
                    etPwd.setText(userData.userPwd)
                }
            }
    }

    private fun initToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_signin)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private val onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                this.isEnabled = false
                onBackPressedDispatcher.onBackPressed()
                overridePendingTransition(R.anim.none, R.anim.mypage_to_main)
            }
        }
}