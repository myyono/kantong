package com.example.myfruits

import java.text.NumberFormat
import java.util.*

fun formatRupiahs(number: Double) : String {
    val localeID = Locale("in", "ID")
    val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
    return formatRupiah.format(number)

}