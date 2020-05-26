package com.diyainfotech.indiafoodreceipes.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.indiafoodreceipes.api.firebase.Cook
import com.diyainfotech.indiafoodreceipes.api.firebase.CookServiceManager
import com.diyainfotech.indiafoodreceipes.databinding.ActivityHomeBinding
import com.diyainfotech.indiafoodreceipes.ui.rssFeed.RssFeedHandler
import com.diyainfotech.indiafoodreceipes.ui.rssFeed.RssFeedListActivity

class HomeActivity : AppCompatActivity(), OnNewsCardClickListener {
    private lateinit var binding: ActivityHomeBinding
    private val cookViewModel: CookViewModel by viewModels()
    private lateinit var cookAdapter: CookAdapter
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
            if (cook != null) {
                Log.d("sanjay", "Cook : $cook")
                CookServiceManager.addValueToList(cook)
            }
        })

        CookServiceManager.cookList.observe(this, Observer {
            cookAdapter = CookAdapter(this)
            cookAdapter.cookList = it
            binding.cooksRecyclerView.adapter = cookAdapter
        })
    }

    override fun onCookCardClick(cook: Cook) {
        RssFeedHandler.currentCook = cook
        val intent = Intent(this, RssFeedListActivity::class.java)
        startActivity(intent)
    }


}
