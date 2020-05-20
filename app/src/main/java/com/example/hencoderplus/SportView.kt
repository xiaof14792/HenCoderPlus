package com.example.hencoderplus

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    style = Paint.Style.STROKE
    strokeWidth = 15f.dp
}
private val RADIUS = 150f.dp
private val TEXT_SIZE = 90f.dp

class SportView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //画灰色圈
        paint.color = ContextCompat.getColor(context, android.R.color.darker_gray)
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        //画粉色弧
        paint.color = ContextCompat.getColor(context, R.color.colorAccent)
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            -90f,
            225f,
            false,
            paint
        )

        //画文字
        paint.style = Paint.Style.FILL
        paint.textSize = TEXT_SIZE
        paint.textAlign = Paint.Align.CENTER //文字绘制水平居中
        //主要难在垂直居中
        val fontMetrics = paint.fontMetrics
        System.out.println(
            "--leading:" + fontMetrics.leading + "; ascent:" + fontMetrics.ascent
                    + "; descent:" + fontMetrics.descent
        )
        canvas.drawText(
            "abab",
            width / 2f,
            height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2,
            paint
        )
    }
}