package com.akash.tracker.covid19.repository

import androidx.lifecycle.LiveData
import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.api.ApiResponse
import com.akash.tracker.covid19.api.ProductService
import com.akash.tracker.covid19.db.ProductDao
import com.akash.tracker.covid19.vo.Product
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

class ProductRepository @Inject constructor(private val appExecutors: AppExecutors,
                                            private val productDao: ProductDao,
                                            private val productService: ProductService) {


    fun loadProductList() : LiveData<Resource<List<Product>>>{
        return object : NetworkBoundResource<List<Product>, List<Product>>(appExecutors = appExecutors){
            override fun saveCallResult(item: List<Product>) {
                //save the response to db
                productDao.insertProducts(item)
            }

            override fun loadFromDb(): LiveData<List<Product>> {
                return productDao.loadProducts()
            }

            override fun shouldFetch(data: List<Product>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<Product>>> {
                //make a retrofit call here
                return productService.getProducts()
            }
        }.asLiveData()
    }
}