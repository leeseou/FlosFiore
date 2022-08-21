package com.example.flosfiore.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Community
import com.example.flosfiore.databinding.FragmentCommunityPostBinding

class CommunityPostFragment: Fragment() {
    lateinit var binding: FragmentCommunityPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityPostBinding.inflate(inflater, container, false)

        val dataList = arrayListOf(
            Community(null, "선인장 분갈이 주기가 어떻게 될까요?", null, "모긴"
                , System.currentTimeMillis(), 4, 0),
            Community(null, "나중에 고양이를 키울 예정인데, 반려식물과 함께 키워도 될지 고민입니다."
                , "수염틸란드시아랑 이것저것 생각중인데 혹시 안되는 식물이 뭐가 있을까요? 혹시나 해 질문 올려봅니다."
                , "모긴", System.currentTimeMillis(), 4, 2),
            Community(R.drawable.img_gallery4, "반려식물을 구입했는데 식물 이름이 궁금해요"
                , "알려주실 분 있으신가요?!", "서우", System.currentTimeMillis(), 4, 3),
            Community(null, "졸업식때 생화는 무슨 종류가 제일 좋을까요??"
                , "추천해 주세요!", "서우", System.currentTimeMillis(), 4, 1),
            Community(null, "첫 반려식물로 무슨 식물이 좋을지 모르겠습니다..."
                , "추천해 주세요!", "서우", System.currentTimeMillis(), 4, 1)
        )

        val communityRVAdapter = PostRVAdapter(dataList)
        binding.communityPostRv.adapter = communityRVAdapter
        binding.communityPostRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}