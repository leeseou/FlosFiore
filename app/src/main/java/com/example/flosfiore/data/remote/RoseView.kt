package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.FlowerPrice

interface RoseView {
    fun onGetRoseLoading()
    fun onGetRoseSuccess(code: Int, result: FlowerPrice)
    fun onGetRoseFailure(code: Int, message: String)
}