package com.example.charo_android.presentation.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.charo_android.R
import com.example.charo_android.databinding.ActivityDetailImageBinding

class DetailImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailImageBinding
    private val viewPagerAdapter = DetailImageViewPagerAdapter()
    private lateinit var imageList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList = intent.getSerializableExtra("imageList") as ArrayList<String>

        initViewPager()
    }

    private fun initViewPager() {
        // viewPager registerOnPageChangeCallback
        binding.viewPagerDetailImage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("Selected_Page", position.toString())
                binding.tvDetailImage.text = "${position+1}/${viewPagerAdapter.itemList.size}"
            }
        })

        binding.viewPagerDetailImage.adapter = viewPagerAdapter
        imageList.forEach {
            viewPagerAdapter.itemList.add(it)
        }
//        viewPagerAdapter.itemList.clear()
//        imgList.forEach {
//            viewPagerAdapter.itemList.add(it)
//        }
        viewPagerAdapter.notifyDataSetChanged()
        binding.tvDetailImage.text = "1/${viewPagerAdapter.itemList.size}"
    }
}