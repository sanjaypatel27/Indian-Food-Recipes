package com.diyainfotech.indiafoodreceipes.api.firebase

import androidx.lifecycle.MutableLiveData

object CookServiceManager {
    var cookList: MutableLiveData<MutableList<Cook>> = MutableLiveData()

    fun addValueToList(cook: Cook) {
        val cookArrayList: MutableList<Cook> = ArrayList()
        val finalCookArrayList = cookList.value
        if (finalCookArrayList != null) {
            val filterCook = finalCookArrayList.singleOrNull { it.name == cook.name }
            if (filterCook == null) {
                cookArrayList.add(cook)
            }
            finalCookArrayList.addAll(cookArrayList)
            cookList.value = finalCookArrayList
        } else {
            cookArrayList.add(cook)
            cookList.value = cookArrayList
        }
    }

}