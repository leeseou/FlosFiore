package com.example.flosfiore.ui.start

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flosfiore.MainActivity
import com.example.flosfiore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginLoginBtn.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        return binding.root
    }
}