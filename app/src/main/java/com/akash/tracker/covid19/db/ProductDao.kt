package com.akash.tracker.covid19.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akash.tracker.covid19.vo.Product

@Dao
interface ProductDao {

    //write some functions to query, insert, update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<Product>)

    @Query("""SELECT * FROM Product""")
    fun loadProducts(): LiveData<List<Product>>
}