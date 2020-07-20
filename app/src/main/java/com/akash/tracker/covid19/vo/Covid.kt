package com.akash.tracker.covid19.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.akash.tracker.covid19.db.CovidTypeConverter
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
@Entity
@TypeConverters(CovidTypeConverter::class)
data class Covid(
	@field:SerializedName("cases_time_series")
	val casesTimeSeries: List<CasesTimeSeriesItem?>? = null,

	@field:SerializedName("tested")
	val tested: List<TestedItem?>? = null,

	@field:SerializedName("statewise")
	val statewise: List<StatewiseItem?>? = null
){
	@PrimaryKey(autoGenerate = true)
	var _id: Int = 0
}