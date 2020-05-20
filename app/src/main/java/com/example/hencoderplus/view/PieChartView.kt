package com.example.hencoderplus.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 150f.dp
private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
private val ANGLES = arrayOf(80f, 120f, 90f, 70f)
private val COLORS = listOf(
    Color.parseColor("#1AE66B"),
    Color.parseColor("#6B1AE6"),
    Color.parseColor("#C48D3C"),
    Color.parseColor("#338FCC")
)
private val seleted = 2 //突出显示哪一块
private val OFFSET = 20f.dp //偏移量

class PieChartView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var startAngle = 0f
        for ((index) in ANGLES.withIndex()) {
            paint.setColor(COLORS[index])
            if (index == seleted) {
                canvas.save()
                canvas.translate(
                    (OFFSET * cos(Math.toRadians((startAngle + ANGLES[index] / 2f).toDouble()))).toFloat(),
                    (OFFSET * sin(Math.toRadians((startAngle + ANGLES[index] / 2f.toDouble()))).toFloat()
                            )
                )
            }
            canvas.drawArc(
                width / 2 - RADIUS,
                height / 2 - RADIUS,
                width / 2 + RADIUS,
                height / 2 + RADIUS,
                startAngle,
                ANGLES[index],
                true,
                paint
            )
            if (index == seleted) {
                canvas.restore()
            }
            startAngle += ANGLES[index]
        }

    }
}