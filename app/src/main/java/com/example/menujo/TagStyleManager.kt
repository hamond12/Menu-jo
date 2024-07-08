package com.example.menujo

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.menujo.data.FoodInfo
import com.example.menujo.data.HistoryInfo
import com.example.menujo.data.UserInfo

class TagStyleManager(private val context: Context) {

    private val tagToStringResourceMap = mapOf(
        "고기" to R.string.cb_meat,
        "meat" to R.string.cb_meat,
        "해산물" to R.string.cb_seafood,
        "seafood" to R.string.cb_seafood,
        "밥" to R.string.cb_rice,
        "rice" to R.string.cb_rice,
        "면" to R.string.cb_noodle,
        "noodle" to R.string.cb_noodle,
        "빵" to R.string.cb_bread,
        "bread" to R.string.cb_bread,
        "매운맛" to R.string.cb_spicy,
        "spicy" to R.string.cb_spicy,
        "중간맛" to R.string.cb_normal,
        "normal" to R.string.cb_normal,
        "순한맛" to R.string.cb_mild,
        "mild" to R.string.cb_mild,
        "야채" to R.string.cb_vegetable,
        "vegetable" to R.string.cb_vegetable
    )

    private val tagToColorResourceMap = mapOf(
        "고기" to R.color.white,
        "meat" to R.color.white,
        "해산물" to R.color.black,
        "seafood" to R.color.black,
        "밥" to R.color.black,
        "rice" to R.color.black,
        "면" to R.color.black,
        "noodle" to R.color.black,
        "빵" to R.color.white,
        "bread" to R.color.white,
        "매운맛" to R.color.white,
        "spicy" to R.color.white,
        "중간맛" to R.color.white,
        "normal" to R.color.white,
        "순한맛" to R.color.black,
        "mild" to R.color.black,
        "야채" to R.color.white,
        "vegetable" to R.color.white
    )

    private fun tagToDrawableResourceMap(tag: String): Int {
        return when (tag) {
            "고기" -> R.drawable.bg_tag_dark_brown
            "meat" -> R.drawable.bg_tag_dark_brown
            "해산물" -> R.drawable.bg_tag_skyblue
            "seafood" -> R.drawable.bg_tag_skyblue
            "밥" -> R.drawable.bg_tag_white
            "rice" -> R.drawable.bg_tag_white
            "면" -> R.drawable.bg_tag_basic
            "noodle" -> R.drawable.bg_tag_basic
            "빵" -> R.drawable.bg_tag_brown
            "bread" -> R.drawable.bg_tag_brown
            "매운맛" -> R.drawable.bg_tag_red
            "spicy" -> R.drawable.bg_tag_red
            "중간맛" -> R.drawable.bg_tag_orange
            "normal" -> R.drawable.bg_tag_orange
            "순한맛" -> R.drawable.bg_tag_yellow
            "mild" -> R.drawable.bg_tag_yellow
            "야채" -> R.drawable.bg_tag_green
            "vegetable" -> R.drawable.bg_tag_green
            else -> R.drawable.bg_tag_white
        }
    }

    fun setTagOfFood(textView: TextView, food: FoodInfo, index: Int) {
        textView.apply {
            visibility = View.VISIBLE
            text = applyText(food.tags[index])
            setTextColor(ContextCompat.getColor(context, applyTextColor(food.tags[index])))
            setBackgroundResource(applyBackgroundByTag(food.tags[index]))
        }
    }

    fun setTagOfUser(textView: TextView, user: UserInfo, index: Int) {
        textView.apply {
            visibility = View.VISIBLE
            text = applyText(user.tags[index])
            setTextColor(ContextCompat.getColor(context, applyTextColor(user.tags[index])))
            setBackgroundResource(applyBackgroundByTag(user.tags[index]))
        }
    }

    fun setTagOfHistory(textView: TextView, history: HistoryInfo, index: Int) {
        textView.apply {
            visibility = View.VISIBLE
            text = applyText(history.tags[index])
            setTextColor(ContextCompat.getColor(context, applyTextColor(history.tags[index])))
            setBackgroundResource(applyBackgroundByTag(history.tags[index]))
        }
    }

    private fun applyText(tag: String): String {
        val resourceId = tagToStringResourceMap[tag.lowercase()]
        return if (resourceId != null) context.getString(resourceId) else ""
    }

    private fun applyTextColor(tag: String): Int {
        return tagToColorResourceMap[tag.lowercase()] ?: R.color.black
    }

    private fun applyBackgroundByTag(tag: String): Int {
        return tagToDrawableResourceMap(tag.lowercase())
    }
}