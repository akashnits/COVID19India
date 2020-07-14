package com.akash.aqua.aactemplate.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akash.aqua.aactemplate.vo.Product

@Dao
interface ProductDao {

    //write some functions to query, insert, update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<Product>)

    @Query("""SELECT * FROM Product""")
    fun loadProducts(): LiveData<List<Product>>
}