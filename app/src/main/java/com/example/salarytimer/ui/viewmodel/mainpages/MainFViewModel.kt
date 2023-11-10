package com.example.salarytimer.ui.viewmodel.mainpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFViewModel : ViewModel() {

    var salary = MutableLiveData<Number>()
    init {
        salary.value = 3000000
    }
}