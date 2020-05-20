package com.example.hencoderplus.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.dp

class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var pointF = PointF(0f, 0f)
    set(value) {
        field = value
        invalidate()
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        strokeWidth = 30.dp
        strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawPoint(pointF.x.toFloat(), pointF.y.toFloat(), paint)
    }
}