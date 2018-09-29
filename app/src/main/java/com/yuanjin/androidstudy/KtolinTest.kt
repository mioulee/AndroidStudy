package com.yuanjin.androidstudy

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.time.LocalDate
import java.time.Period

/**
 * Created by leeyu on 2018/7/13.
 */
object KtolinTest {
    val Int.days: Period
        get() = Period.ofDays(this)
    val Period.ago: LocalDate
        get() = LocalDate.now() - this
    val String.lastChar: Char//扩展属性
        get() = get(length - 1)
    fun String.last():Char = get(length-1)

    @JvmStatic
    fun main(args: Array<String>) {
        var datas = arrayOf(1,2,3,4,23,56,22,"sdfasd",75,23,14,66,88,55,33)
        print(listOf(*datas))
    }

    fun quickSort(datas:Array<Int>,left:Int,right:Int) {
        println("1")
        if(left >= right) {
            return
        }
        var temp = datas[left]
        var i=left+1
        var j=right

        while(i < j) {
            while (i<right&&datas[i] <= temp) {
                i++
            }

            while (j>=left&&datas[j]>temp) {
                j--
            }

            if(i < j) {
                var t = datas[i]
                datas[i] = datas[j]
                datas[j] = t
            }
        }
        datas[left] = datas[i]
        datas[i]=temp
        quickSort(datas,left,i-1)
        quickSort(datas,i+1,right)
    }

    open class PropertyChangeAware {
        protected val changeSupport = PropertyChangeSupport(this)

        fun addPropertyChangeListener(listener: PropertyChangeListener) {
            changeSupport.addPropertyChangeListener(listener)
        }
    }

    class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
        var age: Int = age
            set(value) {
                val oldvalue = field
                field = value
                changeSupport.firePropertyChange("age", oldvalue, field)
            }
    }

    fun twoAndThree(operation: (Int, Int) -> Int) {
        val result = operation
    }
}