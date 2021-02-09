package com.example.myfruits.model

import com.google.gson.annotations.SerializedName


class MyProductData(
    @field:SerializedName("id") var id: Int,
    @field:SerializedName(
        "prname"
    ) var prname: String,
    @field:SerializedName("primage") var primage: String,
    @field:SerializedName(
        "prprice"
    ) var prprice: String
)