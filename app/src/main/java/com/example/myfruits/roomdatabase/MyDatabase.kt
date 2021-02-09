package com.example.myfruits.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room


@Database(entities = [Cart::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
    companion object {

        @Volatile private var instance : MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "note4.db"
        ).build()

    }

}
