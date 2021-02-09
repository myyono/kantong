package com.example.myfruits.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfruits.databinding.DetailpembayaranBinding

class DetailPembayaran: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailpembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}