package com.example.hencoderplus.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hencoderplus.R
import com.example.hencoderplus.dp

private val IMAGE_SIZE = 200.dp
private val IMAGE_PADDING = 100.dp

class FlipView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val avatar = getAvatar(IMAGE_SIZE.toInt())
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val camera = Camera()

    var bottomAngle = 0f
        set(value) {
            field = value
            invalidate()
        }

    var topAngle = 0f
        set(value) {
            field = value
            invalidate()
        }

    var rotateAngle = 0f
        set(value) {
            field = value
            invalidate()
        }


    init {
        camera.apply {
            camera.setLocation(0f, 0f, -9 * resources.displayMetrics.density)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //绘制上面 （旋转30度）
        canvas.save()
        canvas.translate(IMAGE_PADDING + IMAGE_SIZE / 2, IMAGE_PADDING + IMAGE_SIZE / 2)
        canvas.rotate(-rotateAngle)
        camera.save()
        camera.rotateX(topAngle)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(
            -IMAGE_SIZE, -IMAGE_SIZE,
            IMAGE_SIZE, 0f
        )
        canvas.rotate(rotateAngle)
        canvas.translate(-(IMAGE_PADDING + IMAGE_SIZE / 2), -(IMAGE_PADDING + IMAGE_SIZE / 2))
        canvas.drawBitmap(
            avatar,
            IMAGE_PADDING,
            IMAGE_PADDING, paint
        )
        canvas.restore()


        //绘制下面 （旋转30度）
        canvas.save()
        canvas.translate(IMAGE_PADDING + IMAGE_SIZE / 2, IMAGE_PADDING + IMAGE_SIZE / 2)
        canvas.rotate(-rotateAngle)
        camera.save()
        camera.rotateX(bottomAngle)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(
            -IMAGE_SIZE, 0f,
            IMAGE_SIZE,
            IMAGE_SIZE
        )
        canvas.rotate(rotateAngle)
        canvas.translate(-(IMAGE_PADDING + IMAGE_SIZE / 2), -(IMAGE_PADDING + IMAGE_SIZE / 2))
        canvas.drawBitmap(
            avatar,
            IMAGE_PADDING,
            IMAGE_PADDING, paint
        )
        canvas.restore()
    }

    fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(
            resources,
            R.mipmap.avatar_rengwuxian, options
        )
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(
            resources,
            R.mipmap.avatar_rengwuxian, options
        )

    }
}