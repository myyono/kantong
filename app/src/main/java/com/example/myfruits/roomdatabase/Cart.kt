package com.example.myfruits.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @PrimaryKey(autoGenerate= true)
    val id: Int,
    val title: String,
    val cart: String
)
