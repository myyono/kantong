package com.example.myfruits.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfruits.adaptar.Adaptar
import com.example.myfruits.retrofit.MainModel
import com.example.myfruits.R
import com.example.myfruits.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myfruits.roomdatabase.Cart
import kotlinx.android.synthetic.main.tampilan.*


class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    val data = ArrayList<MainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataFromApi()
        setupListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                Toast.makeText(applicationContext, "Pengaturan", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.belanja -> {
                Toast.makeText(applicationContext, "Tentang", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.belanja -> {
                Toast.makeText(applicationContext, "keranjang", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
    fun setupListener(){
        btn.setOnClickListener{
            startActivity(Intent(this, DetailPembayaran::class.java))
        }
    }
}
//Override fun onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_add_tocart);
//    primage=(ImageView)findViewById(R.id.primage);
//    price=(TextView)findViewById(R.id.txtprprice);
//
//    addtocart=(Button)findViewById(R.id.btn);
//addtocart.setOnClickListener(new View.OnClickListener() {
//    @Override
//    class onClick(View v) {
//        Cart cart=new Cart();
//        cart.setId(id);
//        cart.setImageid(imageurl);
//        cart.setName(prname);
//        cart.setPrice(prprice);
//        if (MainActivity.MyDatabase.cartDao().isAddToCart(id)!=1){
//            MainActivity.MyDatabase.cartDao().addToCart(activity_main);
//        }else {
//            Toast.makeText(AddTocartActivity.this, "You are Already added to cart!", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//}







