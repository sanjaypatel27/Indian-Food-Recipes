package com.diyainfotech.indiafoodreceipes.ui.home

import androidx.lifecycle.ViewModel
import com.diyainfotech.indiafoodreceipes.api.firebase.FireBaseDatabaseKey
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CookViewModel : ViewModel() {

    private var databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance().getReferenceFromUrl(FireBaseDatabaseKey.cooksNameListUrl)
    lateinit var cookLiveDataSnapshot: CookLiveDataSnapshot

    fun fetchCookData() {
        cookLiveDataSnapshot = CookLiveDataSnapshot(databaseReference)
    }


}