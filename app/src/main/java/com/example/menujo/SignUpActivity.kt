package com.example.menujo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.example.menujo.data.UserInfo
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {

    private lateinit var userData : UserInfo
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

        //Set layout
        val ivImage = findViewById<ImageView>(R.id.iv_signup_image)
        val etName = findViewById<EditText>(R.id.et_signup_name)
        val etNameLayout = findViewById<TextInputLayout>(R.id.tv_signup_name_layout)
        val etId = findViewById<EditText>(R.id.et_signup_id)
        val etIdLayout = findViewById<TextInputLayout>(R.id.tv_signup_id_layout)
        val etPwd = findViewById<EditText>(R.id.et_signup_pwd)
        val etPwdLayout = findViewById<TextInputLayout>(R.id.tv_signup_pwd_layout)
        val btnSignUp = findViewById<Button>(R.id.btn_signup_signup)
        val cbList = listOf<CheckBox>(
            findViewById(R.id.cb_meat),
            findViewById(R.id.cb_seafood),
            findViewById(R.id.cb_vegetable),
            findViewById(R.id.cb_rice),
            findViewById(R.id.cb_noodle),
            findViewById(R.id.cb_bread),
            findViewById(R.id.cb_spicy),
            findViewById(R.id.cb_normal),
            findViewById(R.id.cb_mild)
        )


        //User data
        val nameData = etName.text
        val idData = etId.text
        val pwdData = etPwd.text
        val tagsData = mutableListOf<String>()

        userData = UserInfo(nameData.toString(), idData.toString(), pwdData.toString(), "", tagsData)

        //Gallery image upload
        val pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                uri?.also { imageUri ->
                    findViewById<ImageView>(R.id.iv_signup_image)?.apply {
                        setPadding(0)
                        setImageURI(imageUri)
                    }
                    findViewById<TextView>(R.id.tv_no_image).visibility = View.GONE
                    contentResolver.takePersistableUriPermission(
                        imageUri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )
                }
            }

        fun openGalleryForImage() {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        fun getGalleryImage() {
            val ivUserImage = findViewById<ImageView>(R.id.iv_signup_image)
            ivUserImage.setOnClickListener {
                openGalleryForImage()
            }
        }
        if (userData.profileImageUrl != "") {
            ivImage.setImageURI(Uri.parse(userData.profileImageUrl))
        } else {
            findViewById<TextView>(R.id.tv_no_image).visibility = View.VISIBLE
        }
        getGalleryImage()

        //Check box
        var cbCount = 0

        cbList.forEach {
            it.setOnCheckedChangeListener { _, ischecked ->
                if (it.isChecked) {
                    cbCount++
                    tagsData += it.text.toString()
                    if (cbCount == 3) {
                        Toast.makeText(
                            this,
                            getString(R.string.toast_signup_favorite_max3),
                            Toast.LENGTH_SHORT
                        ).show()
                        for (i in cbList) if (!i.isChecked) i.isEnabled = false
                    }
                } else {
                    cbCount--
                    tagsData -= it.text.toString()
                    for (i in cbList) if (!i.isChecked) i.isEnabled = true
                }
            }
        }
//
//        //Sign up Button
//        btnSignUp.setOnClickListener {
//            when {
//                nameData.isBlank() -> etNameLayout.error = getString(R.string.toast_signup_name)
//                idData.isBlank() -> etIdLayout.error = getString(R.string.common_set_id)
//                pwdData.isBlank() -> etPwdLayout.error = getString(R.string.common_set_pwd)
//                tagsData.size == 0 -> Toast.makeText(
//                    this,
//                    getString(R.string.toast_signup_favorite_min1),
//                    Toast.LENGTH_SHORT
//                ).show()
//                nameData.length < 2 -> etName.error = getString(R.string.et_signup_name)
//                idData.length < 7 -> etId.error = getString(R.string.et_signup_id)
//                pwdData.length < 7 -> etPwd.error = getString(R.string.et_signup_pwd)
//                else -> {
//                    Toast.makeText(
//                        this,
//                        getString(R.string.common_signup) + getString(R.string.common_finish),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    val intent = Intent(this, SignInActivity::class.java)
//                    intent.putExtra("name",userData.userName)
//                    intent.putExtra("id",userData.userId)
//                    intent.putExtra("pwd",userData.userPwd)
////                    intent.putExtra("tags",userData.tags)
//                    finish()
//                }

        //회원가입버튼, 정규식 사용
        btnSignUp.setOnClickListener {
            val namePattern = "^([a-zA-Z]*)$"
            val idPattern = "^([a-zA-Z0-9]*)$"
            val pwdPattern = "^([0-9]*)$"

            val pattern1 = Pattern.matches(namePattern, nameData)
            val pattern2 = Pattern.matches(idPattern, idData)
            val pattern3 = Pattern.matches(pwdPattern, pwdData)

            when {
                nameData.isBlank() -> etNameLayout.error = getString(R.string.toast_signup_name)
                idData.isBlank() -> etIdLayout.error = getString(R.string.common_set_id)
                pwdData.isBlank() -> etPwdLayout.error = getString(R.string.common_set_pwd)
                nameData.length < 2 -> etName.error = getString(R.string.et_signup_name)
                tagsData.size == 0 -> Toast.makeText(
                    this,
                    getString(R.string.toast_signup_favorite_min1),
                    Toast.LENGTH_SHORT
                ).show()

                idData.length < 7 -> etId.error = getString(R.string.et_signup_id)
                pwdData.length < 7 -> etPwd.error = getString(R.string.et_signup_pwd)
                pattern1 == false -> etName.error = getString(R.string.et_signup_name_pattern)
                pattern2 == false -> etId.error = getString(R.string.et_signup_id_pattern)
                pattern3 == false -> etPwd.error = getString(R.string.et_signup_pwd_pattern)

                else -> {
                    Toast.makeText(
                        this,
                        getString(R.string.common_signup) + getString(R.string.common_finish),
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    intent.putExtra("id", idData.toString())
                    intent.putExtra("password", pwdData.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                    overridePendingTransition(R.anim.none, R.anim.signup_to_signin2)
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