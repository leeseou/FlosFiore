package com.example.flosfiore.ui.main.community

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flosfiore.R
import com.example.flosfiore.data.entities.Post
import com.example.flosfiore.databinding.FragmentCommunityGalleryBinding
import com.example.flosfiore.ui.main.community.detail.CommunityDetailActivity

class CommunityGalleryFragment: Fragment() {
    lateinit var binding: FragmentCommunityGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityGalleryBinding.inflate(inflater, container, false)

        val dataList = arrayListOf(
            Post(R.drawable.img_gallery1, "집안 정원을 장식하는 귀여운 친구들", null, "모긴"
            , System.currentTimeMillis(), 4, 2),
            Post(R.drawable.img_gallery2, "우리집 공기 청정 담당하는 반려식물입니다!", null, "모긴"
                , System.currentTimeMillis(), 4, 2),
            Post(R.drawable.img_gallery3, "집안 정원을 장식하는 귀여운 친구들", null, "모긴"
                , System.currentTimeMillis(), 4, 2)
        )

        val communityRVAdapter = GalleryRVAdapter(dataList)
        binding.communityGalleryRv.adapter = communityRVAdapter
        binding.communityGalleryRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        communityRVAdapter.setMyItemClickListener(object :
            GalleryRVAdapter.MyItemClickListener {
            override fun onItemClick(post: Post) {
                activity.let {
                    val intent = Intent(requireContext(), CommunityDetailActivity::class.java)
                    intent.putExtra("post", post)
                    startActivity(intent)
                }
            }
        })

        return binding.root
    }
}