package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.FlowerPrice

interface HydraView {
    fun onGetHydraLoading()
    fun onGetHydraSuccess(code: Int, result: FlowerPrice)
    fun onGetHydraFailure(code: Int, message: String)
}