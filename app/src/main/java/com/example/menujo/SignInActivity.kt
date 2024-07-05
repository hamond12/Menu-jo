package com.example.menujo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class SignInActivity : AppCompatActivity() {
    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initToolbar()

        //뷰연결
        val etId = findViewById<EditText>(R.id.et_signin_id)
        val etPwd = findViewById<EditText>(R.id.et_signin_pwd)
        val btnSignIn = findViewById<Button>(R.id.btn_signin_signin)
        val btnSignUp = findViewById<Button>(R.id.btn_signin_signup)

        //로그인데이터

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
            }
            else {
                Toast.makeText(
                    this,
                    getString(R.string.common_signin)+getString(R.string.common_finish),
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, MainPageActivity::class.java)
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
                    val id = result.data?.getStringExtra("id")?:""
                    val password = result.data?.getStringExtra("password")?:""
                    etId.setText(id)
                    etPwd.setText(password)
                }
            }
    }

    private fun initToolbar(){
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_signin)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}