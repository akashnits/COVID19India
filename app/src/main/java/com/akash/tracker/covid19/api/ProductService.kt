package com.akash.tracker.covid19.api

import androidx.lifecycle.LiveData
import com.akash.tracker.covid19.vo.Product
import retrofit2.http.GET

interface ProductService {

    //calls to rest apis

    @GET
    fun getProducts() : LiveData<ApiResponse<List<Product>>>

}