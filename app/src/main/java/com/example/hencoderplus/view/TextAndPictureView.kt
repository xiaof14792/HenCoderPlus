package com.example.hencoderplus.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.R
import com.example.hencoderplus.dp
import com.example.hencoderplus.sp

private val IMAGE_SIZE = 150f.dp
private val IMAGE_OFFSET = 50f.dp

class TextAndPictureView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val text =
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32."
    val paint: Paint = Paint().apply {
        textSize = 16.sp
    }
    val fontMetrics = paint.fontMetrics
    val avatar: Bitmap = getAvatar(150f.dp.toInt())


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制图片
        canvas.drawBitmap(avatar, width - IMAGE_SIZE,
            IMAGE_OFFSET, paint)

        //绘制文字
        var textWidth = floatArrayOf(0f)
        var startInex = 0
        var count: Int
        var textOffset: Float = -fontMetrics.top
        val textLength = text.length

        var textMaxWidth = 0f

        while (startInex < textLength){
            //计算绘制文字当前行是否与图片重合，如果重合则不绘制整行以免覆盖图片
            if (textOffset + fontMetrics.bottom < IMAGE_OFFSET || textOffset + fontMetrics.top > IMAGE_OFFSET + IMAGE_SIZE){
                textMaxWidth = width.toFloat();
            }else{
                textMaxWidth = (width - IMAGE_SIZE).toFloat();
            }
            count = paint.breakText(text, startInex, textLength, true, textMaxWidth, textWidth)
            canvas.drawText(text, startInex, startInex + count, 0f, textOffset, paint)

            startInex += count
            textOffset += paint.fontSpacing
        }
    }

    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources,
            R.mipmap.avatar_rengwuxian, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,
            R.mipmap.avatar_rengwuxian, options)

    }
}