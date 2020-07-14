package com.akash.aqua.aactemplate.api

import androidx.lifecycle.LiveData
import com.akash.aqua.aactemplate.vo.Product
import retrofit2.http.GET

interface ProductService {

    //calls to rest apis

    @GET
    fun getProducts() : LiveData<ApiResponse<List<Product>>>

}