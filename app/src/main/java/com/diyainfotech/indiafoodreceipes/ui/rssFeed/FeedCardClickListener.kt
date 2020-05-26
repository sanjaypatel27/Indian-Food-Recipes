package com.diyainfotech.indiafoodreceipes.ui.rssFeed

import com.diyainfotech.indiafoodreceipes.rssFeedParser.Article

interface FeedCardClickListener{
    fun onFeedCardSourceLinkClick(article: Article)
    fun onFeedCardClick(article: Article)
}