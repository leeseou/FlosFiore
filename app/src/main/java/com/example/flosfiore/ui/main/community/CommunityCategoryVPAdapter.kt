package com.example.flosfiore.ui.main.community

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CommunityCategoryVPAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommunityGalleryFragment()
            1 -> CommunityGalleryFragment()
            2 -> CommunityPostFragment()
            3 -> CommunityPostFragment()
            else -> CommunityPostFragment()
        }
    }

}