package com.akash.tracker.covid19.repository

import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.api.CovidService
import com.akash.tracker.covid19.db.CovidDb
import com.akash.tracker.covid19.db.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(appExecutors: AppExecutors,
                                         userDao: UserDao,
                                         covidDb: CovidDb,
                                         covidService: CovidService) {
    //TODO: Do something relevant
}