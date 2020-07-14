package com.akash.aqua.aactemplate

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors {

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