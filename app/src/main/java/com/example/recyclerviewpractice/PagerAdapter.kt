package com.example.recyclerviewpractice

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.recyclerviewpractice.contacts.ui.ContactsFragment
import com.example.recyclerviewpractice.flags.ui.FlagsFragment

class PagerAdapter (
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) FlagsFragment.newInstance() else ContactsFragment.newInstance()
}