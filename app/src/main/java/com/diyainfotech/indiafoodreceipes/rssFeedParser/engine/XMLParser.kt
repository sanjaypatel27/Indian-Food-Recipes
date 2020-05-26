package com.diyainfotech.indiafoodreceipes.rssFeedParser.engine

import com.diyainfotech.indiafoodreceipes.rssFeedParser.Channel
import com.diyainfotech.indiafoodreceipes.rssFeedParser.core.CoreXMLParser
import java.util.concurrent.Callable

class XMLParser(var xml: String) : Callable<Channel> {

    @Throws(Exception::class)
    override fun call(): Channel {
        return CoreXMLParser.parseXML(xml)
    }
}