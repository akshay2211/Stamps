package com.fxn.stamps

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.core.widget.ImageViewCompat

class Stamps : View {

    private var config = Config()

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }

    private fun init(context: Context, attr: AttributeSet?) {
        Log.e("msg","----> <<<<<<<<<<<<<<<<<<<<<")
        config = Config()
        config.init(context, attr)
    }

    override fun onDraw(canvas: Canvas?) {
        //super.onDraw(canvas)
        Log.e("msg","----> "+config.type)

        when (config.type) {
            1 -> {
                config.circular(canvas)
                return
            }
           /* 2 -> {
                config.triangle(canvas)
                return
            }
            3 -> {
                config.square(canvas)
                return
            }
            4 -> {
                config.rectangle(canvas)
                return
            }
            5 -> {
                config.octagonal(canvas)
                return
            }*/

        }

    }
}