package com.example.myfruits.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import retrofit2.http.Query
import androidx.room.*


@Dao
interface CartDao {
    @Insert
     suspend fun addToCart(cart: Cart)

    @Delete
    suspend fun deleteCart(cart: Cart)


    @Query("SELECT * FROM Cart")
    suspend fun getCart(cart: Cart): List<Cart>


}
