package com.akash.tracker.covid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akash.tracker.covid19.repository.CovidRepository
import com.akash.tracker.covid19.ui.common.RetryCallback
import com.akash.tracker.covid19.vo.Covid
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

class CovidViewModel @Inject constructor(private val covidRepository: CovidRepository) : ViewModel(), RetryCallback {

    lateinit var covidData: LiveData<Resource<Covid>>

    fun loadCovidData(){
        covidData=  covidRepository.loadCovidData()
    }

    override fun retry() {
       // try fetching again
        loadCovidData()
    }
}