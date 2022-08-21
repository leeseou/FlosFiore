package com.example.flosfiore.ui.main.community

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flosfiore.HomeCategoryVPAdapter
import com.example.flosfiore.MainActivity
import com.example.flosfiore.databinding.FragmentCommunityBinding
import com.google.android.material.tabs.TabLayoutMediator

// 커뮤니티 프레그먼트
class CommunityFragment : Fragment() {

    lateinit var binding: FragmentCommunityBinding
    private val category = arrayListOf("반려식물 자랑", "플랜테리어", "지식인", "TIP공유", "꽃집 추천")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)

        //카테고리 탭레이아웃, 뷰페이저 연결
        val categoryadapter = CommunityCategoryVPAdapter(this)
        binding.communityCategoryVp.adapter = categoryadapter
        TabLayoutMediator(binding.communityCategoryTb, binding.communityCategoryVp) {
                tab, position ->
            tab.text = category[position]
        }.attach()

        (activity as MainActivity).setSupportActionBar(binding.communityToolbarTb)
        (activity as MainActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return binding.root
    }

}