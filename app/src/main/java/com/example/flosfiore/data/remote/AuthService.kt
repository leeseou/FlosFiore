package com.example.flosfiore.data.remote

import android.util.Log
import com.example.flosfiore.data.entities.User
import com.example.flosfiore.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var signUpView : SignUpView
    private lateinit var loginView: LoginView

    fun setSignUpView(signUpView: SignUpView) {
        this.signUpView = signUpView
    }

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    // 회원가입
    fun signUp(user: User) {

    }

    // 로그인
    fun login(user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)

        //api 호출
        authService.login(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                //응답 처리
                Log.d("LOGIN/SUCCESS", response.toString())
                val resp : AuthResponse = response.body()!!
                when(val code = resp.code) {
                    1000 -> loginView.onLoginSuccess(code)
                    else -> loginView.onLoginFailure()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                //연결 실패
                Log.d("LOGIN/FAILURE", t.message.toString())
            }

        })
        Log.d("LOGIN", "HELLO")
    }
}