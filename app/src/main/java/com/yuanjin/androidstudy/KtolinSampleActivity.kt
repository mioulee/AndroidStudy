package com.yuanjin.androidstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class KtolinSampleActivity : AppCompatActivity() {
    fun main(args:Array<String>) {
        print("asdfas")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktolin_sample)

        findViewById<TextView>(R.id.tv).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
            }
        })
    }
}
