package com.example.charo_android.presentation.ui.onBoarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.charo_android.databinding.ActivityOnBoardingBinding
import com.example.charo_android.presentation.util.SharedInformation
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("sharedOn", SharedInformation.getSocialId(this))
        Log.d("sharedOn", SharedInformation.getEmail(this))

        val pagerAdater = OnBoardingPagerAdapter(this)
        binding.vpOnboarding.adapter = pagerAdater
        binding.dotsIndicator.setViewPager2(binding.vpOnboarding)

    }


    private inner class OnBoardingPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa){
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
                return when(position){
                    0 -> OnBoardingOneFragment()
                    1 -> OnBoardingTwoFragment()
                    else -> OnBoardingThreeFragment()
                }
        }
    }
}