package com.example.infinotest.logic

import android.graphics.*
import com.squareup.picasso.Transformation


class CircleTransformer:Transformation {
    override fun transform(source: Bitmap): Bitmap {
          val  result= Helper.getRoundedCornerBitmap(source, 360)
        if (result != source) {
            source.recycle();
        }
        return result!!
    }

    override fun key(): String {
       return "circle()"
    }




}