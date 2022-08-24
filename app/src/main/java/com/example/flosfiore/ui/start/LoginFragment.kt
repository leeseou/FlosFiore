package com.example.flosfiore.ui.start

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.flosfiore.data.entities.User
import com.example.flosfiore.data.remote.AuthResponse
import com.example.flosfiore.data.remote.AuthService
import com.example.flosfiore.data.remote.LoginView
import com.example.flosfiore.data.remote.Result
import com.example.flosfiore.ui.main.MainActivity
import com.example.flosfiore.databinding.FragmentLoginBinding
import com.example.flosfiore.ui.signup.SignupActivity

class LoginFragment : Fragment(), LoginView {
    lateinit var binding : FragmentLoginBinding
    lateinit var spf : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        spf = requireContext().getSharedPreferences("auth" , MODE_PRIVATE)
        editor = spf.edit()

        binding.loginLoginBtn.setOnClickListener {
            login()
        }

        binding.loginSignupBtn.setOnClickListener {
            startActivity(Intent(requireContext(), SignupActivity::class.java))
        }

        return binding.root
    }

    // 로그인
    private fun login() {
        if(binding.loginIdEt.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if(binding.loginPwEt.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        val email = binding.loginIdEt.text.toString()
        val pwd = binding.loginPwEt.text.toString()

        editor.putString("email", email)
        editor.apply()

        val authService = AuthService()
        authService.setLoginView(this)

        authService.login(User("", email, "", pwd))
    }

    override fun onLoginSuccess(code: Int, result: Result) {
        when(code) {
            1000 -> {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                editor.putString("name", result.name)
                editor.apply()
            }
            else -> {

            }
        }

    }

    override fun onLoginFailure() {
        Toast.makeText(requireContext(), "회원 정보가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
    }
}