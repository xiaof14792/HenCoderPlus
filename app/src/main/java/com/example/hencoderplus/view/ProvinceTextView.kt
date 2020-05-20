package com.example.hencoderplus.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.sp

public val strs = arrayOf(
    "黄浦区",
    "卢湾区",
    "徐汇区",
    "长宁区",
    "静安区",
    "普陀区",
    "闸北区",
    "虹口区",
    "杨浦区",
    "闵行区",
    "宝山区",
    "嘉定区",
    "浦东新区",
    "金山区",
    "松江区",
    "青浦区",
    "南汇区",
    "奉贤区",
    "崇明县"
)

class ProvinceTextView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var province = strs[0]
    set(value) {
        field = value
        invalidate()
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 80.sp
        textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(province, (width / 2).toFloat(), (height / 2).toFloat(), paint)
    }
}