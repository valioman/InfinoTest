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

   init {
       init(attrs)
   }

//    fun isShowText(): Boolean {
//        return mShowText
//    }
//
//    fun setShowText(showText: Boolean) {
//        mShowText = showText
//        invalidate()
//        requestLayout()
//    }


    private fun init(attrs: AttributeSet?) {
        inflate(context,R.layout.menu_button,this)

        val lay = findViewById<ConstraintLayout>(R.id.lay1)
        val leftImage=findViewById<ImageView>(R.id.imageLeft)
        val rightImage=findViewById<ImageView>(R.id.imageRight)
        val headText=findViewById<TextView>(R.id.headtextView)
        val infoText = findViewById<TextView>(R.id.infotextView)
        val leftBadge = findViewById<TextView>(R.id.Badgeleft)
        val rightBadge = findViewById<TextView>(R.id.Badgeright)
        // Load attributes
        val a = context.obtainStyledAttributes(attrs, R.styleable.MenuButton)
        try{
            headText.text=a.getString(R.styleable.MenuButton_text1)
            infoText.text=a.getString(R.styleable.MenuButton_text2)
            val badgeTxt = a.getString(R.styleable.MenuButton_badge)
            val isleft = a.getBoolean(R.styleable.MenuButton_isLeft,true)
            val imageId=a.getResourceId(R.styleable.MenuButton_image,0)

            if(isleft)
            {

                lay.setBackgroundResource(R.drawable.button_left_background)

                leftImage.visibility=View.GONE
                leftBadge.visibility=View.GONE

                if(imageId!=0){
                    rightImage.setImageResource(imageId)
                }
                if(badgeTxt!=null && badgeTxt.isNotEmpty() && !badgeTxt.contentEquals("0")){
                    rightBadge.text=badgeTxt
                }else
                {
                    rightBadge.visibility=View.GONE
                }
            }else
            {
                lay.setBackgroundResource(R.drawable.button_right_background)

                headText.gravity=Gravity.RIGHT
                infoText.gravity=Gravity.RIGHT

                rightImage.visibility=View.GONE
                rightBadge.visibility=View.GONE
                if(imageId!=0){
                    leftImage.setImageResource(imageId)
                }
                if(badgeTxt!=null && badgeTxt.isNotEmpty() && !badgeTxt.contentEquals("0")){
                    leftBadge.text=badgeTxt
                }else{
                    leftBadge.visibility=View.GONE
                }
            }
        }finally {
            a.recycle()
        }

    }

}