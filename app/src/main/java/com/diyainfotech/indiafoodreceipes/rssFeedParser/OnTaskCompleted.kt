package com.diyainfotech.indiafoodreceipes.rssFeedParser

interface OnTaskCompleted {
    fun onTaskCompleted(channel: Channel)
    fun onError(e: Exception)
}