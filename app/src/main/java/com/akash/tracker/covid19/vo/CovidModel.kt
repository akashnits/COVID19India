package com.akash.tracker.covid19.vo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class CovidModel(

	@field:SerializedName("cases_time_series")
	val casesTimeSeries: List<CasesTimeSeriesItem?>? = null,

	@field:SerializedName("tested")
	val tested: List<TestedItem?>? = null,

	@field:SerializedName("statewise")
	val statewise: List<StatewiseItem?>? = null
)