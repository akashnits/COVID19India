package com.akash.tracker.covid19.api

import androidx.lifecycle.LiveData
import com.akash.tracker.covid19.vo.Covid
import retrofit2.http.GET

interface CovidService {

    //calls to rest apis

    @GET("/data.json")
    fun getCovidData() : LiveData<ApiResponse<Covid>>

}