package com.yuanjin.androidstudy.UI.explosianimation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import android.view.Window

/**
 * Created by leeyu on 2018/8/10.
 */
class ExplosionField(context:Context):View(context){
    companion object {
        val TAG = "ExplosionField"
        val mCanvas = Canvas()
    }

    lateinit private var animator:ExplosionAnimator

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        animator.draw(canvas)
    }

    fun explode(view:View?,listener:AnimatorListenerAdapter) {
        var rect: Rect = Rect()
        view?.getGlobalVisibleRect(rect)
        rect.offset(0,-statusBarHeight())

        animator = ExplosionAnimator(this,createBitmapFromView(view),rect)

        animator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
               if(listener != null) {
                   listener.onAnimationStart(animation)
               }
                view?.visibility = View.GONE
                attach2Activity(context as Activity)
//                view?.animate()?.alpha(0f)?.setDuration(50)?.start()
            }

            override fun onAnimationEnd(animation: Animator?) {
                if(listener != null) {
                    listener.onAnimationEnd(animation)
                }
                removeFromActivity(context as Activity)
                view?.animate()?.alpha(1f)?.setDuration(150)?.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
                if(listener != null) listener.onAnimationCancel(animation)
            }

            override fun onAnimationRepeat(animation: Animator?) {
                if(listener != null) listener.onAnimationRepeat(animation)
            }

        })
        animator.start()
    }

    private fun attach2Activity(activity: Activity) {
        var rootView:ViewGroup = activity.findViewById(Window.ID_ANDROID_CONTENT)
        var lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        rootView.addView(this,lp)
    }

    private fun removeFromActivity(activity:Activity) {
        var rootView:ViewGroup = activity.findViewById(Window.ID_ANDROID_CONTENT)
        rootView.removeView(this)
    }

    fun createBitmapFromView(view:View?):Bitmap {
        var bitmap = Bitmap.createBitmap(view!!.width,view!!.height,Bitmap.Config.ARGB_8888)
        if(bitmap != null) {
            synchronized(mCanvas) {
                mCanvas.setBitmap(bitmap)
                view?.draw(mCanvas)
                mCanvas.setBitmap(null)
            }
        }
        return bitmap
    }

    fun statusBarHeight():Int {
        return (Resources.getSystem().displayMetrics.density*25+0.5f).toInt()
    }
}