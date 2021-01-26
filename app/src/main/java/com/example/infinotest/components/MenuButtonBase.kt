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
    abstract val layout:Int
     var imageRes:Int = 0
         set(value) {
             field=value
             setvalues()
         }
     var badge:String=""
         set(value) {
             field=value
             setvalues()
         }
     var text:String=""
         set(value) {
             field=value
             setvalues()
         }
     var descriptionText:String=""
         set(value) {
             field=value
             setvalues()
         }
     var mbClickListener:View.OnClickListener?=null

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
       // Load attributes from xml layout
       val a = context.obtainStyledAttributes(attrs, R.styleable.MenuButtonBase)
       try{
           text = a.getString(R.styleable.MenuButtonBase_text).toString()
           descriptionText = a.getString(R.styleable.MenuButtonBase_descriptionText).toString()
           badge = a.getString(R.styleable.MenuButtonBase_badgeText).toString()
           imageRes=a.getResourceId(R.styleable.MenuButtonBase_imageRes,0)
       }finally {
           a.recycle()
       }
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