package com.example.salarytimer.ui.viewmodel.mainpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainF2ViewModel  : ViewModel() {

    var todaysalary = MutableLiveData<Number>()

    init {
        todaysalary.value = 0
    }


}