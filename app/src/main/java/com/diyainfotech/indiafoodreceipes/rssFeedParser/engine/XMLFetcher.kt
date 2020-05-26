package com.diyainfotech.indiafoodreceipes.rssFeedParser.engine

import com.diyainfotech.indiafoodreceipes.rssFeedParser.core.CoreXMLFetcher
import okhttp3.OkHttpClient
import java.util.concurrent.Callable

class XMLFetcher (private val url: String, private val okHttpClient: OkHttpClient?) :
    Callable<String> {
    @Throws(Exception::class)
    override fun call(): String {
        return CoreXMLFetcher.fetchXML(url, okHttpClient)
    }
}
