package com.example.infinotest

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class MenuButton(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    private var leftBadge:TextView?=null
    private var rightBadge:TextView?=null
    var isLeft:Boolean=true

   init {
       init(attrs)
   }


    var badgeText:String?=null
    set(value){
        field=value
        if(!value.isNullOrEmpty() && !value.contentEquals("0")){
           if(isLeft)
           {
               rightBadge?.text=value
               leftBadge?.visibility=View.GONE
               rightBadge?.visibility=View.VISIBLE
               println("left $value")
           }
            else
           {
               leftBadge?.text=value
               leftBadge?.visibility=View.VISIBLE
               rightBadge?.visibility=View.GONE
               println("right $value")
           }
        }else
        {
         leftBadge?.visibility=View.GONE
         rightBadge?.visibility=View.GONE
        }
        invalidate()
        requestLayout()
    }


    private fun init(attrs: AttributeSet?) {
        inflate(context,R.layout.menu_button,this)

        val lay = findViewById<ConstraintLayout>(R.id.lay1)
        val leftImage=findViewById<ImageView>(R.id.imageLeft)
        val rightImage=findViewById<ImageView>(R.id.imageRight)
        val headText=findViewById<TextView>(R.id.headtextView)
        val infoText = findViewById<TextView>(R.id.infotextView)
        leftBadge = findViewById<TextView>(R.id.Badgeleft)
        rightBadge = findViewById<TextView>(R.id.Badgeright)
        leftBadge?.visibility=View.GONE
        rightBadge?.visibility=View.GONE
        // Load attributes
        val a = context.obtainStyledAttributes(attrs, R.styleable.MenuButton)
        try{
            isLeft= a.getBoolean(R.styleable.MenuButton_isLeft,true)
            headText.text=a.getString(R.styleable.MenuButton_text1)
            infoText.text=a.getString(R.styleable.MenuButton_text2)
            if(infoText.text.isEmpty())infoText.visibility=View.GONE
            badgeText = a.getString(R.styleable.MenuButton_badge)
            val imageId=a.getResourceId(R.styleable.MenuButton_image,0)

            if(isLeft)
            {

                lay.setBackgroundResource(R.drawable.button_left_background)

                leftImage.visibility=View.GONE
                leftBadge?.visibility=View.GONE

                if(imageId!=0){
                    rightImage.setImageResource(imageId)
                }

            }else
            {
                lay.setBackgroundResource(R.drawable.button_right_background)

                headText.gravity=Gravity.RIGHT
                infoText.gravity=Gravity.RIGHT

                rightImage.visibility=View.GONE
                rightBadge?.visibility=View.GONE
                if(imageId!=0){
                    leftImage.setImageResource(imageId)
                }

            }
        }finally {
            a.recycle()
        }

    }


}