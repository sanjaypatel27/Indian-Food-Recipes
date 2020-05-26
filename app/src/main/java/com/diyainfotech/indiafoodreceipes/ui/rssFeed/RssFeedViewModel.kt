package com.diyainfotech.indiafoodreceipes.ui.rssFeed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diyainfotech.indiafoodreceipes.rssFeedParser.Channel
import com.diyainfotech.indiafoodreceipes.rssFeedParser.Parser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class RssFeedViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private lateinit var articleListLive: MutableLiveData<Channel>

    fun getArticleList(): MutableLiveData<Channel> {
        if (!::articleListLive.isInitialized) {
            articleListLive = MutableLiveData()
        }
        return articleListLive
    }

    private fun setChannel(channel: Channel) {
        articleListLive.postValue(channel)
    }

    fun fetchFeed(feedUrl: String) {
        coroutineScope.launch(Dispatchers.Main) {
            try {
                val parser = Parser()
                val articleList = parser.getChannel(feedUrl)
                setChannel(articleList)
            } catch (e: Exception) {
                e.printStackTrace()
                setChannel(Channel(null, null, null, null, null, null, mutableListOf()))
            }
        }
    }
}