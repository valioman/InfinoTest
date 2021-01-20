package com.example.infinotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameView = findViewById<TextView>(R.id.nameView)
        val numberView = findViewById<TextView>(R.id.numberView)
        val infoView = findViewById<TextView>(R.id.infoView)
        val buttCheck= findViewById<MenuButton>(R.id.checkButton)
        val buttOrders = findViewById<MenuButton>(R.id.ordersButton)


        //test data
        nameView.text="Николина Петкова"
        numberView.text="(1234567)"
        infoView.text="последен отчет 01.01.2021 / 10:11"
        buttCheck.badgeText="3"
        buttOrders.badgeText="10"

    }
}