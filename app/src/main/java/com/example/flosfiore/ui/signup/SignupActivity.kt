package com.example.flosfiore.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.User
import com.example.flosfiore.data.remote.AuthResponse
import com.example.flosfiore.data.remote.AuthService
import com.example.flosfiore.data.remote.SignUpView
import com.example.flosfiore.databinding.ActivitySignupBinding

class SignupActivity: AppCompatActivity(), SignUpView {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignupBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setToolBar()

        binding.signupSignupBtn.setOnClickListener {
            signUp()
        }
    }

    // toolbar 뒤로가기 clickListener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // 툴바 설정
    private fun setToolBar() {
        setSupportActionBar(binding.signupToolbarTb)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("JOIN")
    }

    // 회원가입
    private fun signUp() {
        if(binding.signupIdEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if(binding.signupPwEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if(binding.signupNameEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if(binding.signupLocationEt.text.toString().isEmpty()) {
            Toast.makeText(this, "지역을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        val email = binding.signupIdEt.text.toString()
        val pwd = binding.signupPwEt.text.toString()
        val name = binding.signupNameEt.text.toString()
        val location = binding.signupLocationEt.text.toString()

        val authService = AuthService()
        authService.setSignUpView(this)

        authService.signUp(User(name, email, location, pwd))
    }

    override fun onSignUpSuccess() {
        finish()
    }

    override fun onSignUpFailure(code: Int) {
        when(code) {
            2010 -> Toast.makeText(this, "이메일 형식을 정확하게 입력해주세요", Toast.LENGTH_SHORT).show()
            2011 -> Toast.makeText(this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show()
            2015 -> Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
            2014 -> Toast.makeText(this, "지역을 입력해주세요.", Toast.LENGTH_SHORT).show()
            2026, 3004 -> Toast.makeText(this, "비밀번호는 영문자와 숫자를 포함한 8자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show()
        }
    }
}