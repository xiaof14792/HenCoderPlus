package com.example.hencoderplus

import android.animation.TypeEvaluator
import android.graphics.Point
import android.graphics.PointF

class PointTypeEvaluator : TypeEvaluator<PointF> {
    override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {

        val startX = startValue.x
        val startY = startValue.y
        val endX = endValue.x
        val endY = endValue.y

        val currentX = startX + (endX - startX) * fraction
        val currentY = startY + (endY - startY) * fraction

        return PointF(currentX, currentY)
    }
}