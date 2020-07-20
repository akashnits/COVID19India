package com.akash.tracker.covid19.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akash.tracker.covid19.vo.Covid

@Dao
interface CovidDao {

    //write some functions to query, insert, update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(covid: Covid)

//    @Query("""SELECT * FROM Product""")
//    fun loadProducts(): LiveData<List<Product>>
    //TODO: Write query for loaing covid related data

    @Query("""SELECT * FROM Covid""")
   fun loadCovidData(): LiveData<Covid>
}