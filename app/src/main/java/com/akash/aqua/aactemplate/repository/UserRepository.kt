package com.akash.aqua.aactemplate.repository

import com.akash.aqua.aactemplate.AppExecutors
import com.akash.aqua.aactemplate.api.ProductService
import com.akash.aqua.aactemplate.db.ProductDb
import com.akash.aqua.aactemplate.db.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(appExecutors: AppExecutors,
                                         userDao: UserDao,
                                         productDb: ProductDb,
                                         productService: ProductService) {
    //TODO: Do something relevant
}