package com.diyainfotech.indiafoodreceipes.api.firebase

import androidx.lifecycle.MutableLiveData

object CookServiceManager {
    var cookList: MutableLiveData<MutableList<Cook>> = MutableLiveData()

    fun addValueToList(cook: Cook) {
        var cookArrayList: MutableList<Cook> = ArrayList()
        cookArrayList.add(cook)
        var finalCookArrayList = cookList.value
        if (finalCookArrayList != null) {
            finalCookArrayList!!.addAll(cookArrayList)
            cookList.value = finalCookArrayList
        } else {
            cookList.value = cookArrayList
        }

    }

}