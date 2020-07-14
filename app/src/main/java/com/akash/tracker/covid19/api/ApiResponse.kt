package com.akash.tracker.covid19.api

import retrofit2.Response

sealed class ApiResponse<T> {

    companion object{

        fun <T> create(error: Throwable): ApiErrorResponse<T>{
            return ApiErrorResponse(error.message ?: "unknown error")
        }

        //convert from retrofit's response to ApiResponse
        fun <T> create(response: Response<T>): ApiResponse<T>{
            return if(response.isSuccessful){
                val body= response.body()
                // in case response is empty
                if(body == null || response.code() == 204){
                    ApiEmptyResponse()
                }else{
                    ApiSuccessResponse(body)
                }
            }else{
                val msg= response.errorBody()?.toString()
                val errorMsg= if(msg.isNullOrEmpty()){
                    response.message()
                }else{
                    msg
                }
                ApiErrorResponse(errorMsg)
            }
        }
    }
}

data class ApiErrorResponse<T>(val error: String): ApiResponse<T>()

class ApiEmptyResponse<T>: ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T): ApiResponse<T>()