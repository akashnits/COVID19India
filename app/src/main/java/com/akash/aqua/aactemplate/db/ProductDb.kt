package com.akash.aqua.aactemplate.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akash.aqua.aactemplate.vo.Product
import com.akash.aqua.aactemplate.vo.User

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