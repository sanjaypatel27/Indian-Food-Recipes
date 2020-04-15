package com.diyainfotech.indiafoodreceipes.ui.home

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.indiafoodreceipes.api.firebase.Cook
import com.diyainfotech.indiafoodreceipes.databinding.CookCellBinding

class CookViewHolder(private val binding: CookCellBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cook: Cook) {
        Log.d("sanjay", "Cook bind : $cook")
        binding.cookName.text = cook.name
    }
}