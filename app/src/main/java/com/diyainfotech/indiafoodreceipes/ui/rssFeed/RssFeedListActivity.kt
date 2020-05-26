package com.diyainfotech.indiafoodreceipes.ui.rssFeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diyainfotech.indiafoodreceipes.databinding.ActivityRssFeedListAcivityBinding
import com.diyainfotech.indiafoodreceipes.rssFeedParser.Article
import com.diyainfotech.indiafoodreceipes.rssFeedParser.Channel

class RssFeedListActivity : AppCompatActivity(), FeedCardClickListener {
    private lateinit var binding: ActivityRssFeedListAcivityBinding
    private val newsViewModel: RssFeedViewModel by viewModels()
    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
    private lateinit var rssFeedAdaptor: RssFeedAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRssFeedListAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.feedRecyclerView.layoutManager = linearLayoutManager
        subscribers()
    }

    private fun subscribers() {
        newsViewModel.fetchFeed(RssFeedHandler.currentCook.rss_feed_url)

        newsViewModel.getArticleList().observe(this, Observer {
            setupRecyclerview(it!!)
        })
    }

    private fun setupRecyclerview(channel: Channel) {
        rssFeedAdaptor = RssFeedAdaptor(this)
        rssFeedAdaptor.articleList =
            channel.articles
        binding.feedRecyclerView.adapter = rssFeedAdaptor
    }


    private fun openWebView(url: String) {
        WebViewUtil.webViewUrl = url
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    override fun onFeedCardSourceLinkClick(article: Article) {
        openWebView(article.link!!)
    }

    override fun onFeedCardClick(article: Article) {
        openWebView(article.link!!)
    }

}
