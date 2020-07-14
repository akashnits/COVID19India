package com.akash.tracker.covid19.vo

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class TestedItem(

	@field:SerializedName("totalsamplestested")
	val totalsamplestested: String? = null,

	@field:SerializedName("positivecasesfromsamplesreported")
	val positivecasesfromsamplesreported: String? = null,

	@field:SerializedName("samplereportedtoday")
	val samplereportedtoday: String? = null,

	@field:SerializedName("source1")
	val source1: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("testsperconfirmedcase")
	val testsperconfirmedcase: String? = null,

	@field:SerializedName("individualstestedperconfirmedcase")
	val individualstestedperconfirmedcase: String? = null,

	@field:SerializedName("testpositivityrate")
	val testpositivityrate: String? = null,

	@field:SerializedName("testsconductedbyprivatelabs")
	val testsconductedbyprivatelabs: String? = null,

	@field:SerializedName("testedasof")
	val testedasof: String? = null,

	@field:SerializedName("testspermillion")
	val testspermillion: String? = null,

	@field:SerializedName("updatetimestamp")
	val updatetimestamp: String? = null,

	@field:SerializedName("totalindividualstested")
	val totalindividualstested: String? = null,

	@field:SerializedName("totalpositivecases")
	val totalpositivecases: String? = null
)