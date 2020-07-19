package com.akash.tracker.covid19

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppExecutors @Inject constructor(){

     var mDiskIO: Executor
     var mNetworkIO: Executor
     var mMainThread: Executor

    init {
        mDiskIO= Executors.newSingleThreadExecutor()
        mNetworkIO= Executors.newFixedThreadPool(3)
        mMainThread= MainThreadExecutor()
    }

    private class MainThreadExecutor() : Executor{
        val handler= Handler(Looper.getMainLooper())
        override fun execute(runnable: Runnable) {
            handler.post(runnable)
        }
    }
}