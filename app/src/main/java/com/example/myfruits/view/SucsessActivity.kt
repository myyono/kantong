package com.example.myfruits.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.myfruits.R
import com.example.myfruits.delayFunction

class SucsessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucsess)



            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

            delayFunction({toMain()},3000)
        }

        private fun toMain(){
            Intent(this,MainActivity::class.java).run {
                startActivity(this)
            }
        }
    }
