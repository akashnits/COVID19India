package com.akash.tracker.covid19.repository

import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.api.ProductService
import com.akash.tracker.covid19.db.ProductDb
import com.akash.tracker.covid19.db.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(appExecutors: AppExecutors,
                                         userDao: UserDao,
                                         productDb: ProductDb,
                                         productService: ProductService) {
    //TODO: Do something relevant
}