package com.example.charo_android.presentation.ui.setting


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.charo_android.R
import com.example.charo_android.databinding.ActivitySettingBinding
import com.example.charo_android.presentation.base.BaseActivity
import com.example.charo_android.presentation.ui.main.MainActivity
import com.example.charo_android.presentation.ui.setting.viewmodel.SettingViewModel
import com.example.charo_android.presentation.util.changeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {

    private val settingViewModel : SettingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeTabText()
        changeFragment(R.id.fragment_container_setting, SettingMainFragment())

    }

    private fun changeTabText(){
        settingViewModel.updateTabText.observe(this, Observer {
            binding.tvSettingUp.text = it
        })
    }


}