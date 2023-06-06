package com.example.ejercicio2


import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.hypot

class TouchEffectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var touchX: Float = 0f
    private var touchY: Float = 0f
    private var radius: Float = 0f
    private var maxRadius: Float = 80f
    private var animDuration: Long = 300
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var isTouched: Boolean = false
    private var isPressing: Boolean = false

    init {
        paint.color = resources.getColor(android.R.color.holo_blue_dark)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                isTouched = true
                touchX = event.x
                touchY = event.y
                radius = 0f
                maxRadius =50f
                startAnimation()
                return true
            }
            MotionEvent.ACTION_UP -> {
                isTouched = false
                isPressing = false
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                if (isTouched) {
                    isPressing = true
                    touchX = event.x
                    touchY = event.y
                    invalidate()
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        if (isTouched) {
            if (isPressing) {
                canvas.drawCircle(touchX, touchY, radius, paint)
            } else {
                canvas.drawCircle(touchX, touchY, radius, paint)
            }
        }
    }

    private fun startAnimation() {
        val animator = ValueAnimator.ofFloat(0f, maxRadius)
        animator.duration = animDuration
        animator.addUpdateListener { valueAnimator ->
            radius = valueAnimator.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}
