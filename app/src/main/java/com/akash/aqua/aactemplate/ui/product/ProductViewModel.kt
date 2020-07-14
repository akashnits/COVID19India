package com.akash.aqua.aactemplate.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akash.aqua.aactemplate.repository.ProductRepository
import com.akash.aqua.aactemplate.vo.Product
import com.akash.aqua.aactemplate.vo.Resource
import javax.inject.Inject

class ProductViewModel @Inject constructor(productRepository: ProductRepository) : ViewModel() {

    val product: LiveData<Resource<List<Product>>> = productRepository.loadProductList()


}