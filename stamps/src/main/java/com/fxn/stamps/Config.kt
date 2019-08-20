package com.fxn.stamps

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import java.lang.Exception


class Config {

    private var title: String = ""
    private var concentric: Boolean = true
    private var icon: Int = 0
    private var color_start: Int = 0
    private var color_end: Int = 0
    private var gradient_angle: Int = 0
    private var Text_size:Int = 0
    val resourceArray: ArrayList<String> = ArrayList<String>()



    var type: Int = 1

    fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.Stamps)
            try {
                val arrayResourceId = attributes.getResourceId(R.styleable.Stamps_stamps_title_array, 0)
                if (arrayResourceId != 0) {
                    val resourceArray = context.resources.obtainTypedArray(arrayResourceId)
                    for (i in 0 until resourceArray.length()) {
                        val resourceId = resourceArray.getResourceId(i, 0)

                    }
                    resourceArray.recycle()
                }
                title = attributes.getString(R.styleable.Stamps_stamps_title)?:""
                concentric = attributes.getBoolean(R.styleable.Stamps_stamps_concentric_text, false)
                icon = attributes.getResourceId(R.styleable.Stamps_stamps_icon, 0)
                color_start = attributes.getColor(R.styleable.Stamps_stamps_color_start, Color.BLACK)
                color_end = attributes.getColor(R.styleable.Stamps_stamps_color_end, Color.BLACK)
                Text_size = attributes.getInteger(R.styleable.Stamps_stamps_text_size,0)
                gradient_angle = attributes.getInt(R.styleable.Stamps_stamps_color_gradient_angle, 45)
                type = attributes.getInt(R.styleable.Stamps_stamps_type, 1)

            }catch (ex : Exception){
                Log.e("msg","----> <<<<<<<<<<<<<<<<<<<<< "+ex.localizedMessage)
            } finally {
                Log.e("msg","----> <<<<<<<<<<<<<<<<<<<<< finally")
                attributes.recycle()
            }

        }else{
            Log.e("msg","----> <<<<<<<<<<<<<<<<<<<<< atttr is null ")
        }


    }

      fun circular(canvas: Canvas?) {
          val Text = title
         val mPaintText: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

          mPaintText.style = Paint.Style.FILL_AND_STROKE
          mPaintText.shader = SweepGradient(0f, 3f, Color.RED, Color.WHITE)
          mPaintText.textSize = 50f
          val oval = RectF(150f, 300f, 600f, 750f)
          val n = 6
          var sangle = 360/n

          for (i in 0 until (n)) {
              Log.e("lower", "--->>>" + i * sangle)
              val myArc: Path = Path()
              myArc.arcTo(oval, (i * sangle).toFloat(), (-180).toFloat(), true)
              canvas.apply {
                  canvas?.drawTextOnPath(Text, myArc, 0f, 20f, mPaintText)
              }
              Log.e("lower", "------>>>$canvas")

          }



          }


    fun triangle(canvas: Canvas?) {

    }
    fun square(canvas: Canvas?) {
    }
    fun rectangle(canvas: Canvas?) {
    }
    fun octagonal(canvas: Canvas?) {
    }


      }







