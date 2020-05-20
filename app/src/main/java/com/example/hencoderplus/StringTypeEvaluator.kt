package com.example.hencoderplus

import android.animation.TypeEvaluator
import com.example.hencoderplus.view.strs

class StringTypeEvaluator : TypeEvaluator<String> {
    override fun evaluate(fraction: Float, startValue: String?, endValue: String?): String {
        val startIndex = strs.indexOf(startValue)
        val endIndex = strs.indexOf(endValue)

        val currentIndex: Int = (startIndex + (endIndex - startIndex) * fraction).toInt()
        return strs[currentIndex]
    }
}