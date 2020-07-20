package com.akash.tracker.covid19.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akash.tracker.covid19.vo.Covid
import com.akash.tracker.covid19.vo.User

@Database(
    entities = [
    User::class,
    Covid::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CovidDb : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getCovidDao(): CovidDao
}