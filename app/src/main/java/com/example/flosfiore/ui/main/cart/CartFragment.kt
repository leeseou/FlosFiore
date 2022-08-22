package com.example.flosfiore.ui.main.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flosfiore.databinding.FragmentCartBinding

// 장바구니 프레그먼트
class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }
}