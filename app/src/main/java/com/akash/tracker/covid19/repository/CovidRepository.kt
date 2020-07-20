package com.akash.tracker.covid19.repository

import androidx.lifecycle.LiveData
import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.api.ApiResponse
import com.akash.tracker.covid19.api.CovidService
import com.akash.tracker.covid19.db.CovidDao
import com.akash.tracker.covid19.vo.Covid
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

class CovidRepository @Inject constructor(private val appExecutors: AppExecutors,
                                          private val coivdDao: CovidDao,
                                          private val covidService: CovidService) {


    fun loadCovidData() : LiveData<Resource<Covid>>{
        return object : NetworkBoundResource<Covid, Covid>(appExecutors = appExecutors){
            override fun saveCallResult(item: Covid) {
                //save the response to db
                coivdDao.insertData(item)
            }

            override fun loadFromDb(): LiveData<Covid> {
                return coivdDao.loadCovidData()
            }

            override fun shouldFetch(data: Covid?): Boolean {
                //ToDO: write custom logic to refresh
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<Covid>> {
                //make a retrofit call here
                return covidService.getCovidData()
            }
        }.asLiveData()
    }
}