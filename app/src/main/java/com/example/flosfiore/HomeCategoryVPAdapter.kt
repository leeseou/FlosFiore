package com.example.flosfiore

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeCategoryVPAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 8

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeCategoryFragment()
            1 -> HomeCategoryFragment()
            2 -> HomeCategoryFragment()
            3 -> HomeCategoryFragment()
            4 -> HomeCategoryFragment()
            5 -> HomeCategoryFragment()
            6 -> HomeCategoryFragment()
            else -> HomeCategoryFragment()
        }
    }

}