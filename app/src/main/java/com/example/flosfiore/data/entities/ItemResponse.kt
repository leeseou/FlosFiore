package com.example.flosfiore.data.entities

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: FlowerPrice
)

data class FlowerPrice(
    @SerializedName("flowerAgePrice") val flowerAgePrice : Int
)
