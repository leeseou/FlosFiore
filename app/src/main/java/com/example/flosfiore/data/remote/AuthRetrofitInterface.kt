package com.example.flosfiore.data.remote

import com.example.flosfiore.data.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRetrofitInterface {
    // 회원가입
    @POST("/new/users")
    fun signUp(@Body user: User): Call<AuthResponse>

    // 로그인
    @POST("/auth/login")
    fun login(@Body user: User): Call<AuthResponse>
}