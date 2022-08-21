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
import com.example.flosfiore.databinding.FragmentCommunityGalleryBinding

class CommunityGalleryFragment: Fragment() {
    lateinit var binding: FragmentCommunityGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityGalleryBinding.inflate(inflater, container, false)

        val dataList = arrayListOf(
            Community(R.drawable.img_gallery1, "집안 정원을 장식하는 귀여운 친구들", "", "모긴"
            , System.currentTimeMillis(), 4, 2),
            Community(R.drawable.img_gallery2, "우리집 공기 청정 담당하는 반려식물입니다!", "", "모긴"
                , System.currentTimeMillis(), 4, 2),
            Community(R.drawable.img_gallery3, "집안 정원을 장식하는 귀여운 친구들", "", "모긴"
                , System.currentTimeMillis(), 4, 2)
        )

        val communityRVAdapter = GalleryRVAdapter(dataList)
        binding.communityGalleryRv.adapter = communityRVAdapter
        binding.communityGalleryRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}