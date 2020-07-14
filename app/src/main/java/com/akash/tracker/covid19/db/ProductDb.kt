package com.akash.tracker.covid19.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akash.tracker.covid19.vo.Product
import com.akash.tracker.covid19.vo.User

@Database(
    entities = [
    User::class,
    Product::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ProductDb : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getProductDao(): ProductDao
}