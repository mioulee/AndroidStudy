package com.yuanjin.androidstudy.UI.explosianimation

import android.graphics.Point
import android.graphics.Rect
import java.util.*

/**
 * Created by leeyu on 2018/8/10.
 */
open class ParticleModel(color:Int,bound:Rect,point:Point) {
    companion object {
        val PART_WH:Float = 8f
        val random:Random = Random()
    }

    var cx:Float = bound.left+ PART_WH*point.x
    var cy:Float = bound.top+PART_WH*point.y
    var radius:Float = PART_WH
    var color:Int = color
    var alpha:Float = 1f
    var mBound:Rect = bound

    constructor():this(0, Rect(),Point())

    fun advance(factor:Float) {
        cx += factor*random.nextInt(mBound.width())*(random.nextFloat()-0.5f)
        cy += factor*random.nextInt(mBound.height()/2)

        radius = radius - factor*random.nextInt(2)
        alpha = (1f-factor)*(1+random.nextFloat())
    }
}