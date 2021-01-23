package com.example.infinotest.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.example.infinotest.R

class LeftMenuButton(context: Context, attrs: AttributeSet?) : MenuButtonBase(context,attrs) {
    override var imageRes: Int = 0
        set(value) {
            field=value
            setvalues()
        }
    override var badge: String = ""
        set(value) {
            field=value
            setvalues()
        }
    override var text: String = ""
        set(value) {
            field=value
            setvalues()
        }
    override var descriptionText: String = ""
        set(value) {
            field=value
            setvalues()
        }
    override var mbClickListener: OnClickListener?=null
        set(value) {field=value}


    override val layout: Int
        get() = R.layout.menu_button_left

    init {
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


}