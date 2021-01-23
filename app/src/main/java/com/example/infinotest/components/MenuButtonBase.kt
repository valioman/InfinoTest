package com.example.infinotest.components

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.infinotest.R


abstract class MenuButtonBase(context: Context, attrs: AttributeSet?):LinearLayout(context,attrs) {
    abstract var imageRes:Int
    abstract var badge:String
    abstract var text:String
    abstract var descriptionText:String
    abstract var mbClickListener:View.OnClickListener?
    abstract val layout:Int
    private val textView:TextView
    private val descrView:TextView
    private val badgeView:TextView
    private val imageView:ImageView
   init {
       val v= inflate(context, layout, this)
        textView= v.findViewById(R.id.textBox)
       descrView= v.findViewById(R.id.descriptionBox)
       badgeView= v.findViewById(R.id.badgeBox)
       imageView= v.findViewById(R.id.imageBox)
       badgeView.visibility= View.GONE

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(ev?.action?.equals(MotionEvent.ACTION_UP) == true){
            this.mbClickListener?.onClick(this)
        }
        return super.dispatchTouchEvent(ev)
    }


    fun setvalues(){
        textView.text=text
        descrView.text=descriptionText
        if(badge.isNullOrEmpty() || badge.contentEquals("0")|| badge.contentEquals("null"))
        {
            badgeView.text=""
            badgeView.visibility= View.GONE
        }else
        {
            badgeView.text=badge
            badgeView.visibility= View.VISIBLE
        }
        if(imageRes!=0) imageView.setImageResource(imageRes)
        invalidate()
        requestLayout()
    }
}