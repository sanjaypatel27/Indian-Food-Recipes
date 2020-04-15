package com.diyainfotech.indiafoodreceipes.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diyainfotech.indiafoodreceipes.R
import com.diyainfotech.indiafoodreceipes.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textHome.text ="View Binding Test"
    }
}
