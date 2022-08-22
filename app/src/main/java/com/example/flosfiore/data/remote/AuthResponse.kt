package com.example.flosfiore.data.remote

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName(value = "isSuccess") val isSuccess:Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String
)