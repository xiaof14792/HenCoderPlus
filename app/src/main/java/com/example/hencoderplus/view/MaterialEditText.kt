package com.example.hencoderplus.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.EditText
import com.example.hencoderplus.R
import com.example.hencoderplus.dp
import com.example.hencoderplus.sp

private val TEXT_SIZE = 15.dp //标签字体大小
private val TEXT_MARGIN = 8.dp //标签字体距顶部距离

private val TEXT_VERTICAL_OFFSET = 10.dp //标签纵坐标偏移量
private val TEXT_HORIZONCAL_OFFSET = 4.dp //标签横坐标偏移量

class MaterialEditText(context: Context, attrs: AttributeSet?) : EditText(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.colorAccent)
        textSize = TEXT_SIZE
    }

    var showLabel = false

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
        if (!showLabel && !text.isNullOrEmpty()) {
            val animator = ObjectAnimator.ofFloat(this, "labelFraction", 0f, 1f)
            animator.start()
            showLabel = true
        } else if (showLabel && text.isNullOrEmpty()) {
            val reverseAnimator = ObjectAnimator.ofFloat(this, "labelFraction", 1f, 0f)
            reverseAnimator.start()
            showLabel = false
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (0xff * labelFraction).toInt() //随动画进度更改label字体透明度
        var verticalOffset = TEXT_VERTICAL_OFFSET + TEXT_SIZE + (1 - labelFraction) * textSize.sp / 2 //纵坐标偏移量

        if (labelFraction > 0) {
            canvas.drawText(hint.toString(), TEXT_HORIZONCAL_OFFSET, verticalOffset, paint)
        }
    }
}