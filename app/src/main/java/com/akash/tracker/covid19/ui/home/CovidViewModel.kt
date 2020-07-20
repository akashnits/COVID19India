package com.akash.tracker.covid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akash.tracker.covid19.repository.CovidRepository
import com.akash.tracker.covid19.ui.common.RetryCallback
import com.akash.tracker.covid19.vo.Covid
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

class CovidViewModel @Inject constructor(private val covidRepository: CovidRepository) : ViewModel(), RetryCallback {

    val covidData: LiveData<Resource<Covid>> = covidRepository.loadCovidData()

    override fun retry() {
       // try fetching again
        covidRepository.loadCovidData()
    }
}