package com.example.infinotest.logic

import android.graphics.*


class Helper {
    companion object{
        fun getRoundedCornerBitmap(bitmap: Bitmap, pixels: Int): Bitmap? {
            val output = Bitmap.createBitmap(
                bitmap.width, bitmap
                    .height, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(output)
            val color = Color.parseColor("#ff424242")
            val paint = Paint()
            val rect = Rect(0, 0, bitmap.width, bitmap.height)
            val rectF = RectF(rect)
            val roundPx = pixels.toFloat()
            paint.isAntiAlias = true
            canvas.drawARGB(0, 0, 0, 0)
            paint.color = color
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(bitmap, rect, rect, paint)
            return output
        }

        fun textAsBitmap(text: String, textSize: Float, textColor: Int, backColor: Int): Bitmap {

            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.textSize = textSize
            paint.color = textColor
            paint.textAlign = Paint.Align.LEFT
            val baseline = -paint.ascent()
            var width = (paint.measureText(text) + 0.0f).toInt()
            var height = (baseline + paint.descent() + 0.0f).toInt()
            val trueWidth = width
            val framewidth=12
            if (width > height) height = width else width = height
            val image = Bitmap.createBitmap(width+framewidth, height+framewidth, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(image)
            canvas.drawColor(backColor)
            canvas.drawText(text, (width / 2 - trueWidth / 2).toFloat()+framewidth/2, baseline+framewidth.toFloat()/1.5f, paint)
            return image
        }
    }
}