package com.example.hencoderplus.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.R
import com.example.hencoderplus.dp

private val IMAGE_PADDING = 20f.dp
private val IMAGE_WIDTH = 150f.dp
private val mXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
private val stroke_width = 3f.dp

private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

}

class AvatarView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //绘制圆形头像
        //必须要应用离屏缓冲，才能达到需要的效果
        val count = canvas.saveLayer(
            IMAGE_PADDING,
            IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH,
            IMAGE_PADDING + IMAGE_WIDTH,
            paint
        )
        canvas.drawOval(
            IMAGE_PADDING,
            IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH,
            paint
        )
        val avatarBitmap = getAvatar(IMAGE_WIDTH.toInt())

        paint.xfermode = mXfermode
        canvas.drawBitmap(avatarBitmap,
            IMAGE_PADDING,
            IMAGE_PADDING,
            paint
        )
        canvas.restoreToCount(count)

        //头像黑色边框
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = stroke_width
        canvas.drawOval(
            IMAGE_PADDING,
            IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH,
            IMAGE_PADDING + IMAGE_WIDTH,
            paint
        )
    }


    fun getAvatar(width: Int): Bitmap{
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