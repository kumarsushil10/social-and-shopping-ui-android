package com.example.social.presentation.account

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AccountPagerAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0-> OrderedListFragment()
           1 -> PostsFragment()
           2 -> TaggedFragment()
           else -> SavedFragment()
       }
    }
}