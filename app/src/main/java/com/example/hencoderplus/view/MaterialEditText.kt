package com.example.hencoderplus.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.EditText
import com.example.hencoderplus.R
import com.example.hencoderplus.dp

private val TEXT_SIZE = 15.dp
private val TEXT_MARGIN = 8.dp

private val TEXT_OFFSET = 8.dp
private val TEXT_HORIZONCAL_OFFSET = 4.dp

class MaterialEditText(context: Context, attrs: AttributeSet?) : EditText(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.colorAccent)
        textSize = TEXT_SIZE
    }

    val showLabel = true

    var labelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
        get() = field

    init {
        setPadding(
            paddingLeft,
            (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(),
            paddingEnd,
            paddingBottom
        )
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (lengthBefore == 0 && lengthAfter > 0) {
            val animator = ObjectAnimator.ofFloat(this, "labelFraction", 0f, 1f)
            animator.duration = 1000
            animator.start()
        } else if (lengthBefore > 0 && lengthAfter == 0) {
            val reverseAnimator = ObjectAnimator.ofFloat(this, "labelFraction", 1f, 0f)
            reverseAnimator.duration = 1000
            reverseAnimator.start()
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (0xff * labelFraction).toInt() //随动画进度更改label字体透明度
        if (!text.isNullOrEmpty()) {
            canvas.drawText(hint.toString(), TEXT_HORIZONCAL_OFFSET, TEXT_OFFSET + TEXT_SIZE, paint)
        }
    }
}