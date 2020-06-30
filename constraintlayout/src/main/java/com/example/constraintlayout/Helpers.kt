package com.example.constraintlayout

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible

class Helpers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_barrier)

//        setContentView(R.layout.activity_group)
//        val group = findViewById<View>(R.id.group)
//        findViewById<View>(R.id.button).setOnClickListener { v ->
//            group.visibility = if (group.isVisible) GONE else VISIBLE
//        }

        setContentView(R.layout.activity_layer)
        val layer = findViewById<View>(R.id.layer)
        findViewById<View>(R.id.button).setOnClickListener { v ->
            layer.rotation = 45f
            layer.translationX = 100f
            layer.translationY = 200f
            layer.scaleX = 2f
            layer.scaleY = 2f
        }
    }
}