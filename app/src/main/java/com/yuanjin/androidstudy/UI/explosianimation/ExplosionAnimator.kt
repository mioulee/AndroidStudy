package com.yuanjin.androidstudy.UI.explosianimation

import android.animation.ValueAnimator
import android.graphics.*
import android.view.View

/**
 * Created by leeyu on 2018/8/10.
 */
class ExplosionAnimator(view: View, bitmap: Bitmap, bound: Rect) : ValueAnimator() {
    companion object {
        val DEFAULT_DURATION:Long = 600
    }

    init{
        setDuration(DEFAULT_DURATION)
        setFloatValues(0f,1.0f)
    }

    var mParticles = generateParticles(bitmap,bound)
    var mContainer = view
    var mPaint = Paint()

    private fun generateParticles(bitmap: Bitmap, bound: Rect): Array<Array<ParticleModel>> {
        var w = bound.width()
        var h = bound.height()

        var horizontalCount = (w / ParticleModel.PART_WH).toInt()
        var verticalCount = (h / ParticleModel.PART_WH).toInt()
        var bitmapPartWidth = bitmap.width / horizontalCount
        var bitmapPartHeight = bitmap.height / verticalCount

        var particles = Array(verticalCount) {Array<ParticleModel>(horizontalCount,{i:Int -> ParticleModel()})}

        for (row in 0..verticalCount-1) {
            for (colum in 0..horizontalCount-1) {
                var color = bitmap.getPixel(colum * bitmapPartWidth, row * bitmapPartHeight)

                var point: Point = Point(colum, row)
                particles[row][colum] = ParticleModel(color, bound, point)
            }

        }
        return particles
    }

    fun draw(canvas: Canvas?) {
        if (!isStarted) {
           return
        }

        for (particle:Array<ParticleModel> in mParticles) {
            for(p:ParticleModel in particle) {
                p.advance(getAnimatedValue() as Float)
                mPaint.color = p.color
                mPaint.alpha = (Color.alpha(p.color)*p.alpha).toInt()
                canvas?.drawCircle(p.cx,p.cy,p.radius,mPaint)
            }
        }

        mContainer.invalidate()
    }

    override fun start() {
        super.start()
        mContainer.invalidate()
    }
}