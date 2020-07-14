package com.akash.tracker.covid19.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.api.ApiEmptyResponse
import com.akash.tracker.covid19.api.ApiErrorResponse
import com.akash.tracker.covid19.api.ApiResponse
import com.akash.tracker.covid19.api.ApiSuccessResponse
import com.akash.tracker.covid19.vo.Resource
import javax.inject.Inject

// A class to manage data consistency when poor/no network; provides offline capabilities to app
abstract class NetworkBoundResource<ResultType, RequestType>  constructor(private val appExecutors: AppExecutors) {

    var result= MediatorLiveData<Resource<ResultType>>()
    init {
        //set UI to loading status
        Resource.loading(null)
        //set source for data - db source
        @Suppress("LeakingThis")
        val dbSource= loadFromDb()
        // we are adding dbSource here to determine if we need to fetch data from network
        // data from db helps us taking that decision
        result.addSource(dbSource){data ->
            result.removeSource(dbSource)
            if(shouldFetch(data)){
                fetchFromNetwork(dbSource)
            }else{
                result.addSource(dbSource){newValue ->
                    setValue(Resource.success(newValue))
                }
            }
        }
    }

    private fun setValue(newValue: Resource<ResultType>){
        if(result.value != newValue){
            result.value= newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>){
        //make api call using retrofit
        val apiResponse= createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(dbSource){value ->
            setValue(Resource.success(value))
        }
        result.addSource(apiResponse){response ->
            result.removeSource(dbSource)
            result.removeSource(apiResponse)

            when(response){
                is ApiSuccessResponse -> {
                    appExecutors.mDiskIO.execute{
                        //saving result in database
                        saveCallResult(processResponse(response))
                        appExecutors.mMainThread.execute{
                            //reload from db, fetch latest data after network call
                            result.addSource(loadFromDb()){newValue ->
                                setValue(Resource.success(newValue))
                            }
                        }
                    }
                }

                is ApiEmptyResponse -> {
                    //reload from disk whatever we have
                    result.addSource(loadFromDb()){existingValue ->
                        setValue(Resource.success(existingValue))
                    }
                }

                is ApiErrorResponse -> {
                    onFetchFailed()
                    result.addSource(dbSource){value ->
                        setValue(Resource.error(response.error, value))
                    }
                }
            }
        }
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    protected open fun onFetchFailed() {}

    protected abstract fun saveCallResult(item: RequestType)

    protected open fun processResponse(response: ApiSuccessResponse<RequestType>)=  response.body

    protected  abstract fun loadFromDb(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}