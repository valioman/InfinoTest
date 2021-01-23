package com.example.infinotest

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.infinotest.components.MenuButtonBase
import com.example.infinotest.logic.CircleTransformer
import com.example.infinotest.logic.Helper
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameView = findViewById<TextView>(R.id.nameView)
        val numberView = findViewById<TextView>(R.id.numberView)
        val infoView = findViewById<TextView>(R.id.infoView)
        val avatarImage = findViewById<ImageView>(R.id.avatarImage)


        val mbFill = findViewById<MenuButtonBase>(R.id.mbFill)
        val mbPay = findViewById<MenuButtonBase>(R.id.mbPay)
        val mbReports = findViewById<MenuButtonBase>(R.id.mbReports)
        val mbInfo = findViewById<MenuButtonBase>(R.id.mbInfo)
        val mbOrders = findViewById<MenuButtonBase>(R.id.mbOrders)

        val mbCheck= findViewById<MenuButtonBase>(R.id.mbCheck)
        val mbContrib = findViewById<MenuButtonBase>(R.id.mbContrib)
        val mbResults = findViewById<MenuButtonBase>(R.id.mbResults)
        val mbMessages = findViewById<MenuButtonBase>(R.id.mbMessages)
        val mbProfile = findViewById<MenuButtonBase>(R.id.mbProfile)

        mbFill.mbClickListener=this
        mbPay.mbClickListener=this
        mbReports.mbClickListener=this
        mbInfo.mbClickListener=this
        mbOrders.mbClickListener=this
        mbCheck.mbClickListener=this
        mbContrib.mbClickListener=this
        mbResults.mbClickListener=this
        mbMessages.mbClickListener=this
        mbProfile.mbClickListener=this

        //test data
        nameView.text="Николина Петкова"
        numberView.text="(1234567)"
        infoView.text="последен отчет 01.01.2021 / 10:11"
        mbCheck.badge="3"
        mbOrders.badge="10"
        Picasso.get()
            .load(R.drawable.woman)
            .transform(CircleTransformer())
            .into(avatarImage)
//        val bitmap = Helper.textAsBitmap("AB",36f, Color.WHITE,Color.BLACK)
//        avatarImage.setImageBitmap(Helper.getRoundedCornerBitmap(bitmap, 360))
    }

    override fun onClick(v: View?) {
        if(v is MenuButtonBase) {
            Toast.makeText(this, "${v.text} Clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,FillActivity::class.java))
        }
    }
}