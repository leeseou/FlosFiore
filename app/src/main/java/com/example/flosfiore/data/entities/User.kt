package com.example.flosfiore.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "userName") var userName: String,
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "region") var region: String,
    @SerializedName(value = "pwd") var pwd: String
)
