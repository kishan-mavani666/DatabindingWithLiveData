package com.example.databindingwithlivedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    val titleMutableLiveData: MutableLiveData<String> =
        MutableLiveData("This is mutable live data")

    val titleLiveData: LiveData<String>
        get() = titleMutableLiveData

    fun updateData() {
        titleMutableLiveData.value = "This is updated data"
    }
}