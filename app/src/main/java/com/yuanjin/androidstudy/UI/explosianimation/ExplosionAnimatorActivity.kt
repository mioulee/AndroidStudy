package com.yuanjin.androidstudy.UI.explosianimation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.yuanjin.androidstudy.R

class ExplosionAnimatorActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_explosion_animator)

        findViewById<View>(R.id.view).setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                if(v?.visibility == View.GONE) {
                    v?.visibility = View.VISIBLE
                }else {
                    ExplosionField(this@ExplosionAnimatorActivity).explode(v,object:AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            v?.visibility = View.INVISIBLE
                        }
                    })
                }
            }

        })
    }
}
