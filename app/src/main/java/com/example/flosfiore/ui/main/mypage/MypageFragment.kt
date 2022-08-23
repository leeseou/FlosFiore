package com.example.flosfiore.ui.main.mypage

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.flosfiore.R
import com.example.flosfiore.databinding.FragmentMypageBinding
import com.example.flosfiore.ui.main.MainActivity

// 마이페이지 프레그먼트
class MypageFragment : Fragment() {

    lateinit var binding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)

        (activity as MainActivity).setSupportActionBar(binding.mypageToolbarTb)
        (activity as MainActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_toolbar_back)

        return binding.root
    }


//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.toolbar_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }


}