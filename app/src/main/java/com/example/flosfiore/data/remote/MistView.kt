package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.FlowerPrice

interface MistView {
    fun onGetMistLoading()
    fun onGetMistSuccess(code: Int, result: FlowerPrice)
    fun onGetMistFailure(code: Int, message: String)
}