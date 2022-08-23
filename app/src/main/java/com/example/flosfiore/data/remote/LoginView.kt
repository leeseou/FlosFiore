package com.example.flosfiore.data.remote

interface LoginView {
    fun onLoginSuccess(code: Int)
    fun onLoginFailure()
}