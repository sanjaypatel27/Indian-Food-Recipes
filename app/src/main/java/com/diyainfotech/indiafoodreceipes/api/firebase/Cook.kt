package com.diyainfotech.indiafoodreceipes.api.firebase


data class Cook(
    var about_site: String,
    val location: String,
    val name: String,
    val position: Int,
    var rss_feed_url: String,
    val since: String,
    val site: String,
    val frequency: String,
    var author_image_url: String
){
    constructor() : this("", "", "", -1, "", "","","","")
}