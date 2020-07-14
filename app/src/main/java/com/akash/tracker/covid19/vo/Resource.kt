package com.akash.tracker.covid19.vo

// A holder class to contain data along with status

data class Resource<out T>(val status: Status, val data: T?, val msg: String?= null) {

    companion object{

        fun <T> success(data: T?) : Resource<T>{
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(msg: String?, data: T?) : Resource<T>{
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data : T?) : Resource<T>{
            return Resource(Status.LOADING, data)
        }
    }
}