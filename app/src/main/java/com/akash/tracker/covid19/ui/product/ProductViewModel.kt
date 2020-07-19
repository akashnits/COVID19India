package com.akash.tracker.covid19.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akash.tracker.covid19.repository.ProductRepository
import com.akash.tracker.covid19.ui.common.RetryCallback
import com.akash.tracker.covid19.vo.Product
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel(), RetryCallback {

    val product: LiveData<Resource<List<Product>>> = productRepository.loadProductList()

    override fun retry() {
       // try fetching again
        productRepository.loadProductList()
    }
}