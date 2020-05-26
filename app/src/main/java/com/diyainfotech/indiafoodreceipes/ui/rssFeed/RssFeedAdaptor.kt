package com.diyainfotech.indiafoodreceipes.ui.rssFeed

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diyainfotech.indiafoodreceipes.extensions.autoNotify
import com.diyainfotech.indiafoodreceipes.extensions.inflate
import com.diyainfotech.indiafoodreceipes.rssFeedParser.Article
import com.diyainfotech.indiafoodreceipes.R
import kotlin.properties.Delegates

class RssFeedAdaptor(private val feedCardClickListener: FeedCardClickListener) : RecyclerView.Adapter<FeedViewHolder>() {
    var articleList: List<Article> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.title == n.title }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflatedView = parent.inflate(R.layout.rss_feed_view_cell, false)
        return FeedViewHolder(inflatedView,feedCardClickListener)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindData(articleList[position])
    }
}