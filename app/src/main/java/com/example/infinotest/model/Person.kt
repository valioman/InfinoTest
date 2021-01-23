package com.example.infinotest.model

data class Person(
    val name:String,
    val surName:String?=null,
    val familyName:String,
    val avatarUrl:String?=null,
    val avatarResId:Int?=null//used for tests
)
