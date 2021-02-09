package com.example.myfruits.view

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myfruits.model.MyProductData
import com.example.myfruits.roomdatabase.MyDatabase
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.tampilan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var rv: RecyclerView? = null
    var cartbtn: ImageView? = null
    var cartcount: TextView? = null
    var myProductAdapter: MyProductAdapter = null

    class MyProductAdapter {

    }

    var myProductData: List<MyProductData>? = null


        MainActivity.Companion.myDatabase = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "My_Cart"
        ).allowMainThreadQueries().build()
        getdata()
    }



    private fun getdata() {
        val call: Call<List<MyProductData>> = Myretrofit.getInstance().getMyApi().getProductData()
        call.enqueue(object : Callback<List<MyProductData?>?>() {
            fun onResponse(
                call: Call<List<MyProductData?>?>?,
                response: Response<List<MyProductData?>?>
            ) {
                myProductData = response.body()
                myProductAdapter = MyProductAdapter(myProductData, this@MainActivity)
                rv!!.adapter = myProductAdapter
            }

            fun onFailure(call: Call<List<MyProductData?>?>?, t: Throwable?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        updatacartcount()
    }

    companion object {
        var myDatabase: MyDatabase? = null
    }
}


