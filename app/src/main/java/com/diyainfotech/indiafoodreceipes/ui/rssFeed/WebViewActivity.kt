package com.diyainfotech.indiafoodreceipes.ui.rssFeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.diyainfotech.indiafoodreceipes.R
import com.diyainfotech.indiafoodreceipes.util.CustomWebView

class WebViewActivity : AppCompatActivity() {
    lateinit var customWebView: CustomWebView
    lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_webview)
        viewInflation()
    }

    private fun viewInflation() {
        customWebView = findViewById(R.id.customWebView)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        WebViewUtil.setUpWebView(customWebView, swipeRefresh)
        loadUrl()
        swipeRefresh.setOnRefreshListener(OnRefreshListener
        {
            loadUrl()
        })
    }

    private fun loadUrl() {
        if (!TextUtils.isEmpty(WebViewUtil.webViewUrl)) {
            WebViewUtil.loadUrlIntoWebView(WebViewUtil.webViewUrl, customWebView)
        }
    }
}
