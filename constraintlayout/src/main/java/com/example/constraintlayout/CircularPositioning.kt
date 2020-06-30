package com.example.constraintlayout

import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout

class CircularPositioning : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_positioning)

        val sun = findViewById<AppCompatImageView>(R.id.sun)
        val moon = findViewById<AppCompatImageView>(R.id.moon)
        val earth = findViewById<AppCompatImageView>(R.id.earth)

        val moonAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 10000
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                val params: ConstraintLayout.LayoutParams = moon.layoutParams as ConstraintLayout.LayoutParams
                params.circleAngle = 45 + it.animatedFraction * 360
            }
        }

        val earthAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 2000
            repeatCount = INFINITE
            interpolator = LinearInterpolator()
            addUpdateListener {
                val params: ConstraintLayout.LayoutParams = earth.layoutParams as ConstraintLayout.LayoutParams
                params.circleAngle = 270 + it.animatedFraction * 360
                earth.requestLayout()
            }
        }

        sun.setOnClickListener {
            moonAnimator.start()
            earthAnimator.start()
        }

    }
}