package com.example.recyclerviewpractice.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.recyclerviewpractice.ui.contacts.ContactsFragment
import com.example.recyclerviewpractice.ui.flags.FlagsFragment

class PagerAdapter (
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) FlagsFragment.newInstance() else ContactsFragment.newInstance()
}