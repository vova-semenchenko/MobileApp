package com.example.mobileapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ChangeTextModel : ViewModel() {
    private val _changedText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val changedText: LiveData<String>
        get()  = _changedText

    fun setText(value: String){
        _changedText.value = value
    }
}