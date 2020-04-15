package com.diyainfotech.indiafoodreceipes.ui.home

import androidx.lifecycle.LiveData
import com.google.firebase.database.*

class CookLiveDataSnapshot : LiveData<DataSnapshot?> {
    private val databaseReference: DatabaseReference
    private val childEventListener = CookAddChildEventListener()

    constructor(databaseReference: DatabaseReference) {
        this.databaseReference = databaseReference
    }


    override fun onActive() {
        super.onActive()
        databaseReference.addChildEventListener(childEventListener)
    }

    override fun onInactive() {
        super.onInactive()
        databaseReference.removeEventListener(childEventListener)
    }

    private inner class CookAddChildEventListener :
        ChildEventListener {
        override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
            value = dataSnapshot
        }

        override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {
            value = dataSnapshot
        }

        override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
        override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
        override fun onCancelled(databaseError: DatabaseError) {}
    }

}