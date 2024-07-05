package com.example.menujo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

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
        showsnackbar()
        initToolBar()

        findViewById<ImageButton>(R.id.ib_koreanfood).setOnClickListener {
            initImageButton(it)
        }
        findViewById<ImageButton>(R.id.ib_chinesefood).setOnClickListener {
            initImageButton(it)
        }
        findViewById<ImageButton>(R.id.ib_westernfood).setOnClickListener {
            initImageButton(it)
        }
        findViewById<ImageButton>(R.id.ib_japanesefood).setOnClickListener {
            initImageButton(it)
        }
        //animation test
    }

    private fun showsnackbar() {
        val snackbarBtn = findViewById<Button>(R.id.btn_snackbar)
        snackbarBtn.setOnClickListener {

            val random = Random
            val num = random.nextInt(5)

            val message = when (num) {
                0 -> getString(R.string.main_snackbar_not_full)
                1 -> getString(R.string.main_snackbar_not_curious)
                2 -> getString(R.string.main_snackbar_dawn)
                3 -> getString(R.string.main_snackbar_diet)
                else -> getString(R.string.main_snackbar_bbb)

            }

            val snack1 = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .setAction("종료하세요~")
                {
                    finish()
                }

            snack1.setTextColor(Color.BLACK)
            snack1.setBackgroundTint(Color.WHITE)
            snack1.animationMode =
                Snackbar.ANIMATION_MODE_FADE //스낵바가 아래에서 위로 올라오는 것과 같은 애니메이션 모드 변경
            snack1.show()
        }
    }

    private fun initImageButton(view: View) {
        when (view.getId()) {
            R.id.ib_koreanfood -> {
                val intent = Intent(this, FoodListActivity::class.java)
                intent.putExtra("food", "koreanFood")
                startActivity(intent)
                overridePendingTransition(R.anim.main_to_koreanfood, R.anim.none)
            }

            R.id.ib_chinesefood -> {
                val intent = Intent(this, FoodListActivity::class.java)
                intent.putExtra("food", "chineseFood")
                startActivity(intent)
                overridePendingTransition(R.anim.main_to_chinesefood, R.anim.none)
            }

            R.id.ib_westernfood -> {
                val intent = Intent(this, FoodListActivity::class.java)
                intent.putExtra("food", "westernFood")
                startActivity(intent)
                overridePendingTransition(R.anim.main_to_westernfood, R.anim.none)
            }

            R.id.ib_japanesefood -> {
                val intent = Intent(this, FoodListActivity::class.java)
                intent.putExtra("food", "japaneseFood")
                startActivity(intent)
                overridePendingTransition(R.anim.main_to_japanesefood, R.anim.none)
            }
        }
    }

    private fun initToolBar() {
        val accountIcon = findViewById<ImageView>(R.id.iv_right_icon)
        val userName = findViewById<TextView>(R.id.tv_user_name)
        val loginBtn = findViewById<Button>(R.id.btn_login)

        loginBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        val user_Name = intent.getStringExtra("userNameKey") ?: "????"
        userName.text = getString(R.string.main_sir, user_Name)


        //마이페이지 클릭하면 유저 아이디를 마이페이지로 전달
        accountIcon.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            intent.putExtra("userID", user_Name)
            startActivity(intent)

            overridePendingTransition(R.anim.main_to_mypage, R.anim.none)
        }
    }
}


//if (email == "" && password == ""){ // 로그인이 안되어 있다고 과정하고 로그인 페이지를 띄운다.
//    val btnLogin = findViewById<Button>(R.id.btnLogin) as Button
//    btnLogout.visibility = View.GONE // GONE-사라지다. 로그인이 안되어 있으면 로그아웃을 볼 필요가 없으므로 GONE 한다.
//    btnLogin.setOnClickListener{
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//    }
//} else {
//    val btnLogout = findViewById<Button>(R.id.btnLogout) as Button
//    btnLogin.visibility = View.GONE // 반대로 로그인이 되어 있는 상태에서 로그인을 볼 필요가 없기에 GONE 한다.
//    btnLogout.setOnClickListener{
//        val intent = Intent(this, LogoutActivity::class.java)
//        startActivity(intent)
//    }

/*    private fun initToolBar() {
        val accountIcon = findViewById<ImageView>(R.id.iv_right_icon)
        val userName = findViewById<TextView>(R.id.tv_user_name)
        val loginBtn = findViewById<Button>(R.id.btn_login)

        loginBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        //회원가입에서 user이름 가져오는 임시 코드 !!
        val user_Name = intent.getStringExtra("userNameKey") ?: "????"
        userName.text = getString(R.string.main_sir, user_Name)


        // 로그인 확인 조건문(임시)
        if (false) {
            loginBtn.setVisibility(View.VISIBLE)
            accountIcon.setVisibility(View.GONE)
            userName.setVisibility(View.GONE)
        } else {
            loginBtn.setVisibility(View.GONE)
            accountIcon.setVisibility(View.VISIBLE)
            userName.setVisibility(View.GONE)
        }

<<<<<<< HEAD
=======
        loginBtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.main_to_signin, R.anim.none)
        }

>>>>>>> 76674cce3dd877ed6ad1ec586d5b21169fd808f0
        //마이페이지 클릭하면 유저 아이디를 마이페이지로 전달
        accountIcon.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            intent.putExtra("userID", user_Name)
            startActivity(intent)

            overridePendingTransition(R.anim.main_to_mypage, R.anim.none)
        }
    }*/
