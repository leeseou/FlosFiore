package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.FlowerPrice

interface LisianView {
    fun onGetLisianLoading()
    fun onGetLisianSuccess(code: Int, result: FlowerPrice)
    fun onGetLisianFailure(code: Int, message: String)
}