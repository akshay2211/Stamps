package com.fxn.stamps

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet


class Config {
    fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.Stamps, 0, 0)
            try {
                val arrayResourceId = attributes.getResourceId(R.styleable.Stamps_stamps_title_array, 0)
                if (arrayResourceId != 0) {
                    val resourceArray = context.resources.obtainTypedArray(arrayResourceId)
                    for (i in 0 until resourceArray.length()) {
                        val resourceId = resourceArray.getResourceId(i, 0)

                    }
                    resourceArray.recycle()
                }

                val title = attributes.getString(R.styleable.Stamps_stamps_title)
                val concentric = attributes.getBoolean(R.styleable.Stamps_stamps_concentric_text, false)
                val icon = attributes.getResourceId(R.styleable.Stamps_stamps_icon, 0)
                val color_start = attributes.getColor(R.styleable.Stamps_stamps_color_start, Color.BLACK)
                val color_end = attributes.getColor(R.styleable.Stamps_stamps_color_end, Color.BLACK)
                val gradient_angle = attributes.getInt(R.styleable.Stamps_stamps_color_gradient_angle, 45)
                val type = attributes.getInt(R.styleable.Stamps_stamps_type, 1)

            } finally {
                attributes.recycle()


            }
        }

    }
}