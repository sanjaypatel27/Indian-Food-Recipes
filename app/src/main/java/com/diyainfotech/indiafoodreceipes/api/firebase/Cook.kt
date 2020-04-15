package com.diyainfotech.indiafoodreceipes.api.firebase

import com.google.firebase.database.PropertyName

data class Cook(
    @PropertyName("about_site")
    val aboutSite: String,
    val location: String,
    val name: String,
    val position: Int,
    @PropertyName("rss_feed_url")
    val rssFeedUrl: String,
    val since: String,
    val site: String
){
    constructor() : this("", "", "", -1, "", "","")
}