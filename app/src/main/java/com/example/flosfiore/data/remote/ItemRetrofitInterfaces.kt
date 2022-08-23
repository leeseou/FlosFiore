package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.ItemResponse
import retrofit2.Call
import retrofit2.http.GET

interface ItemRetrofitInterfaces {
    @GET("/master/price수국")
    fun getHydra(): Call<ItemResponse>

    @GET("/master/price장미")
    fun getRose(): Call<ItemResponse>

    @GET("/master/price안개꽃")
    fun getMist(): Call<ItemResponse>

    @GET("/master/price리시안셔스")
    fun getLisian(): Call<ItemResponse>
}