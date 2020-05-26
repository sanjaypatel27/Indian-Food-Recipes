package com.diyainfotech.indiafoodreceipes.ui.home

import com.diyainfotech.indiafoodreceipes.api.firebase.Cook

interface OnNewsCardClickListener{
    fun onCookCardClick(cook: Cook)
}