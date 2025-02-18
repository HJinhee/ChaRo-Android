package com.example.charo_android.presentation.ui.more.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charo_android.presentation.ui.setting.viewmodel.SettingViewModel

class MoreThemeViewPagerAdapter(fm: FragmentActivity ) : FragmentStateAdapter(fm) {

    var fragments = listOf<Fragment>()

    override fun getItemCount(): Int = fragments.count()

    override fun createFragment(position: Int): Fragment{
        return fragments[position]
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}