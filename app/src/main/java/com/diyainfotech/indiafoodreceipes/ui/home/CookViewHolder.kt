package com.diyainfotech.indiafoodreceipes.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.diyainfotech.indiafoodreceipes.R
import com.diyainfotech.indiafoodreceipes.api.firebase.Cook
import com.diyainfotech.indiafoodreceipes.databinding.CookCellBinding

class CookViewHolder(private val binding: CookCellBinding, private val onNewsCardClickListener: OnNewsCardClickListener) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private lateinit var currentCook: Cook

    @SuppressLint("SetTextI18n")
    fun bind(cook: Cook) {
        currentCook = cook
        Log.d("sanjay", "Cook bind : $cook")
        binding.cookCard.setOnClickListener(this)
        binding.cookName.text = cook.name
        binding.position.text = "${cook.position}."
        binding.aboutSite.text = "About Site : ${cook.about_site}"
        binding.since.text = "Since : ${cook.since}"
        binding.location.text = cook.location
        binding.frequency.text = "Frequency ${cook.frequency}"
        binding.site.text = cook.site
        binding.image.load(cook.author_image_url)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.cook_card) {
            onNewsCardClickListener.onCookCardClick(currentCook)
        }
    }
}