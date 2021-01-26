package com.example.myfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var currentPage = 0
    private var numPages = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            "https://www.pexels.com/id-id/foto/blueberry-dan-stroberi-dalam-mangkuk-keramik-putih-1120575/",
            "https://www.pexels.com/id-id/foto/orang-yang-memegang-buah-bulat-kuning-5871215/",
             "https://www.pexels.com/id-id/foto/tiga-buah-apel-209339/",
        )

        createSlider(images)
    }
    private fun createSlider(string: List<String>) {

            vpSlider.adapter = SliderAdapter(this, string)
            indicator.setViewPager(vpSlider)
            val density = resources.displayMetrics.density
            //Set circle indicator radius
            indicator.radius = 5 * density
            numPages = string.size
            // Auto getData of viewpager
            val update = Runnable {
                if (currentPage === numPages) {
                    currentPage = 0
                }
                vpSlider.setCurrentItem(currentPage++, true)
            }
            val swipeTimer = Timer()
            swipeTimer.schedule(object : TimerTask() {
                override fun run() {
                    android.os.Handler(Looper.getMainLooper()).post(update)
                }
            }, 5000, 5000)
            // Pager listener over indicator
            indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageSelected(position: Int) {
                    currentPage = position
                }

                override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {}
                override fun onPageScrollStateChanged(pos: Int) {}
            })
        }
    }