package com.akash.tracker.covid19.ui.home

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akash.tracker.covid19.repository.CovidRepository
import com.akash.tracker.covid19.ui.common.RetryCallback
import com.akash.tracker.covid19.vo.Covid
import com.akash.tracker.covid19.vo.Resource
import com.akash.tracker.covid19.vo.StatewiseItem
import javax.inject.Inject

class CovidViewModel @Inject constructor(private val covidRepository: CovidRepository) : ViewModel(), RetryCallback {

    lateinit var covidData: LiveData<Resource<Covid>>

    var covidStatewiseItemList: MutableLiveData<Resource<List<StatewiseItem?>?>> = MutableLiveData()

    fun loadCovidData(){
        covidData=  covidRepository.loadCovidData()
        Handler().postDelayed({
            covidStatewiseItemList.value= Resource.success(covidData.value?.data?.statewise)

        } , 5000)
    }

    override fun retry() {
       // try fetching again
        loadCovidData()
    }
}