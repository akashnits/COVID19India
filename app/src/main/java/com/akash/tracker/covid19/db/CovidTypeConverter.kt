package com.akash.tracker.covid19.db

import androidx.room.TypeConverter
import com.akash.tracker.covid19.vo.CasesTimeSeriesItem
import com.akash.tracker.covid19.vo.StatewiseItem
import com.akash.tracker.covid19.vo.TestedItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


/**
 * Created by akash on 20,July,2020
 */
object CovidTypeConverter {
    @TypeConverter
    @JvmStatic
    fun stringToCasesTimeSeriesItemList(data: String?): List<CasesTimeSeriesItem> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<CasesTimeSeriesItem?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun casesTimeSeriesItemListToString(casesTimeSeriesItemList: List<CasesTimeSeriesItem?>?): String {
        return Gson().toJson(casesTimeSeriesItemList)
    }

    @TypeConverter
    @JvmStatic
    fun stringToTestedItemList(data: String?): List<TestedItem> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<TestedItem?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun testedItemListToString(testedItemList: List<TestedItem?>?): String {
        return Gson().toJson(testedItemList)
    }

    @TypeConverter
    @JvmStatic
    fun stringToStatewiseItemList(data: String?): List<StatewiseItem> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<StatewiseItem?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun statewiseItemListToString(statewiseItemList: List<StatewiseItem?>?): String {
        return Gson().toJson(statewiseItemList)
    }
}