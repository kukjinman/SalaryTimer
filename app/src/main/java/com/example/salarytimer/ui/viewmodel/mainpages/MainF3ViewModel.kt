package com.example.salarytimer.ui.viewmodel.mainpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainF3ViewModel : ViewModel() {

    var monthSalarySum = MutableLiveData<Number>()

    init {
        monthSalarySum.value = 0
    }


}