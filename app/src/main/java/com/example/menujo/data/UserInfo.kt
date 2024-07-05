package com.example.menujo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val userId: String,
    val userName: String,
    val userPwd: String,
    val profileImageUrl: String,
    val tags: List<String>
) : Parcelable
