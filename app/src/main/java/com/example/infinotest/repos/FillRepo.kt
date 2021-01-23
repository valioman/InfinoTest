package com.example.infinotest.repos

import com.example.infinotest.R
import com.example.infinotest.model.CreditState
import com.example.infinotest.model.ItemFill
import com.example.infinotest.model.Person

class FillRepo {
    fun getAll():Array<ItemFill>{
        return  arrayOf(
            ItemFill(
                Person("Свилен",familyName = "Радичков",avatarResId =  R.drawable.man),
                "Преди 25 мин",
               CreditState("Статус на кредит",R.color.light_yellow_200),"разглежда се от офис",
                "234567",null
            ),
            ItemFill(
                Person("Милена",familyName = "Костадинова",avatarResId =  R.drawable.woman),
                "Преди 45 мин",
                 CreditState("Подпис и изплащане",R.color.light_blue_400),"одобрен",
                "23456787",null
            ),
            ItemFill(
                Person("Петра",familyName = "Николова"),
                "Преди 5 ч.",
                CreditState("Статус на кредит",R.color.light_blue_400),"усвоен",
                "23411787",null
            ),
            ItemFill(
                Person("Цветанка","Иванова", "Тодорова"),
                "Преди 3 ч.",
                CreditState("Статус на кредит",R.color.transparent),"изплатен",
                "23433787",null
            ),
            ItemFill(
                Person("Цветанка","Иванова", "Тодорова"),
                "Преди 3 ч.",
                CreditState("Статус на кредит",R.color.light_purple_200),"в процес",
                "23433787",null
            ),
            ItemFill(
                Person("Милена",familyName = "Костадинова",avatarResId =  R.drawable.woman),
                "Преди 45 мин",
                CreditState("Подпис и изплащане",R.color.light_orange_200),"очаква изплащане",
                "23456787","1903.00 лв."
            )
        )
    }


}