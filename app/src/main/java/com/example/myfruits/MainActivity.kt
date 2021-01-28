package com.example.myfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfruits.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    val data = ArrayList<MainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataFromApi()
    }

    private fun getDataFromApi() {
        ApiService.endpoint.getData().enqueue(object : Callback<List<MainModel>> {
            override fun onResponse(
                call: Call<List<MainModel>>,
                response: Response<List<MainModel>>
            ) {
                if(response.isSuccessful) {
                    Log.d("checking", response.isSuccessful.toString())
                    data.addAll(response.body()!!)
                    list.layoutManager = LinearLayoutManager(this@MainActivity)
                    list.adapter = Adaptar(data) {
                        Toast.makeText(this@MainActivity, "you clicked ${it.title}", Toast.LENGTH_SHORT).show()
                    }
                    list.adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                printlog(t.message.toString())
                Log.d("checking", t.message.toString())
            }

        })

    }

    private fun printlog(message: String) {
        Log.d(TAG, message)
    }

    override fun onStart() {
        super.onStart()
    }
}

