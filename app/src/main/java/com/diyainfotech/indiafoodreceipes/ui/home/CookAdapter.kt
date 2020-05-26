package com.diyainfotech.indiafoodreceipes.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.indiafoodreceipes.extensions.autoNotify
import com.diyainfotech.indiafoodreceipes.api.firebase.Cook
import com.diyainfotech.indiafoodreceipes.databinding.CookCellBinding
import kotlin.properties.Delegates

class CookAdapter(private val onNewsCardClickListener: OnNewsCardClickListener) :
    RecyclerView.Adapter<CookViewHolder>() {

    var cookList: List<Cook> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.name == n.name }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CookViewHolder(
        CookCellBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), onNewsCardClickListener
    )

    override fun onBindViewHolder(holder: CookViewHolder, position: Int) {
        holder.bind(cookList[position])
    }

    override fun getItemCount(): Int {
        return cookList.size
    }
}