package com.akash.aqua.aactemplate.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = ["id"]
)
data class Product (
    @field:SerializedName("id")
    var id: String,
    @field:SerializedName("name")
    var name: String,
    @field:SerializedName("description")
    var description: String,
    @field:SerializedName("category")
    var category: String,
    @field:SerializedName("brand")
    var brand: String,
    @field:SerializedName("price")
    var price: Double
)