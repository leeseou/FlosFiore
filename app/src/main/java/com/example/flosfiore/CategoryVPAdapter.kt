package com.example.flosfiore

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryVPAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 8

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CategoryFragment()
            1 -> CategoryFragment()
            2 -> CategoryFragment()
            3 -> CategoryFragment()
            4 -> CategoryFragment()
            5 -> CategoryFragment()
            6 -> CategoryFragment()
            else -> CategoryFragment()
        }
    }

}