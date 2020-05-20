package com.example.hencoderplus.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 150f.dp
private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
private val OPEN_ANGLE = 120f

private val path: Path = Path()
private val dashPath: Path = Path()
private lateinit var dashEffect: PathEffect
private val pathMeasure: PathMeasure = PathMeasure()

private val DASH_WIDTH = 3f.dp
private val DASH_LENGTH = 10f.dp

private val PROGRESS = 5 //指针进度，在第几格
private val POINTER_LENGTH = 100f.dp


class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f.dp

        dashPath.addRect(0f, 0f,
            DASH_WIDTH,
            DASH_LENGTH, Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        path.reset()
        path.addArc(
            width / 2 - RADIUS,
            height / 2 - RADIUS,
            width / 2 + RADIUS,
            height / 2 + RADIUS,
            90f + OPEN_ANGLE / 2,
            360 - OPEN_ANGLE
        )

        pathMeasure.setPath(path, false)
        dashEffect = PathDashPathEffect(
            dashPath,
            (pathMeasure.length - DASH_WIDTH) / 20,
            0f,
            PathDashPathEffect.Style.ROTATE
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //画弧
        canvas.drawPath(path, paint)

        //画刻度
        paint.setPathEffect(dashEffect)
        canvas.drawPath(path, paint)
        paint.setPathEffect(null)

        //画指针
        canvas.drawLine(
            width / 2f, height / 2f,
            width / 2f + (POINTER_LENGTH * cos(Math.toRadians((90f + OPEN_ANGLE / 2 + (360 - OPEN_ANGLE) * PROGRESS / 20).toDouble()))).toFloat(),
            height / 2f + (POINTER_LENGTH * sin(Math.toRadians((90f + OPEN_ANGLE / 2 + (360 - OPEN_ANGLE) * PROGRESS / 20).toDouble()))).toFloat(),
            paint
        )
    }
}