package com.example.constraintlayout

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class ConstraintSetX : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_constrain_set)
//
//    }
//
//    fun onClick(view: View) {
//        val constrainLayout = view as ConstraintLayout
//        val constraintSet = ConstraintSet().apply {
//            clone(constrainLayout)
//            connect(R.id.twitter, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//        }
//
//        constraintSet.applyTo(view)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrain_start)

    }

    fun onClick(view: View) {
        val constraintLayout = view as ConstraintLayout
        val constraintSet = ConstraintSet().apply {
            isForceId = false
            clone(this@ConstraintSetX, R.layout.activity_constrain_end)
        }

        TransitionManager.beginDelayedTransition(constraintLayout) //添加渐变动画
        constraintSet.applyTo(constraintLayout)
    }
}

