package com.example.infinotest.components

import android.content.Context
import android.util.AttributeSet
import com.example.infinotest.R

class LeftMenuButton(context: Context, attrs: AttributeSet?) : MenuButtonBase(context,attrs) {
     override val layout: Int
        get() = R.layout.menu_button_left
}