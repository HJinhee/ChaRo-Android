package com.example.charo_android.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.charo_android.R
import com.example.charo_android.databinding.ActivityNoSearchBinding
import com.example.charo_android.databinding.ActivitySearchBinding
import com.example.charo_android.ui.write.WriteActivity

class NoSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userId : String = intent.getStringExtra("userId").toString()
        clickBackButton(userId)
        clickWriteButton()
    }


    private fun clickBackButton(userId: String) {
        binding.imgBackHome.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }

    }

    private fun clickWriteButton(){
        binding.imgNoSearchClick.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

    }
}