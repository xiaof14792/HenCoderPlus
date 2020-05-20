package com.example.hencoderplus

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hencoderplus.view.strs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //动画1
        /*val circleAnimator = ObjectAnimator.ofFloat(circleView, "radius", 150.dp)
        circleAnimator.startDelay = 1000
        circleAnimator.start()*/


        //动画2
        /*val pointAnimator = ObjectAnimator.ofObject(
            pointView,
            "pointF",
            PointTypeEvaluator(),
            PointF(50.dp, 150.dp)
        )
        pointAnimator.startDelay = 1000
        pointAnimator.duration = 1000
        pointAnimator.start()*/

        //动画3
        /*val bottomFlipAnimator = ObjectAnimator.ofFloat(flipView, "bottomAngle", 0f, 45f)
        bottomFlipAnimator.startDelay = 1000

        val rotateAnimator = ObjectAnimator.ofFloat(flipView, "rotateAngle", 270f)
        rotateAnimator.duration = 2000

        val topFlipAnimator = ObjectAnimator.ofFloat(flipView, "topAngle", 0f, -45f)
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, rotateAnimator, topFlipAnimator)
        animatorSet.start()*/

        //动画4
        /*val provinceAnimator = ObjectAnimator.ofObject(
            provinceView,
            "province",
            StringTypeEvaluator(),
            "黄浦区",
            "崇明县"
        )
        provinceAnimator.startDelay = 1000
        provinceAnimator.duration = 10000
        provinceAnimator.start()*/

    }
}
