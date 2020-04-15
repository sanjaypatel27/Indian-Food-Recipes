package com.diyainfotech.indiafoodreceipes.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.indiafoodreceipes.api.firebase.Cook
import com.diyainfotech.indiafoodreceipes.api.firebase.CookServiceManager
import com.diyainfotech.indiafoodreceipes.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val cookViewModel: CookViewModel by viewModels()
    private lateinit var cookFirebaseRecyclerAdapter: CookFirebaseRecyclerAdapter
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.cooksRecyclerView.layoutManager = linearLayoutManager
        initData()
    }

    private fun initData() {
        cookViewModel.fetchCookData()
        cookViewModel.cookLiveDataSnapshot.observe(this, Observer {
            val cook: Cook? = it!!.getValue(Cook::class.java)
            if(cook != null){
                Log.d("sanjay","Cook : $cook")
                CookServiceManager.addValueToList(cook)
            }
        })

        CookServiceManager.cookList.observe(this, Observer {
            cookFirebaseRecyclerAdapter = CookFirebaseRecyclerAdapter()
            cookFirebaseRecyclerAdapter.cookList = it
            binding.cooksRecyclerView.adapter = cookFirebaseRecyclerAdapter
        })
    }



}
