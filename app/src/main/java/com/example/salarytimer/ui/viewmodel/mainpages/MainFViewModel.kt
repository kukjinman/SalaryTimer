package com.example.salarytimer.ui.viewmodel.mainpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainFViewModel : ViewModel() {

    var salary = MutableLiveData<Number>()

    var startHour = MutableLiveData<Int>()
    var startMinute = MutableLiveData<Int>()
    var endHour = MutableLiveData<Int>()
    var endMinute = MutableLiveData<Int>()



    init {
        salary.value = 3000000

        startHour.value = 9
        startMinute.value = 0
        endHour.value = 17
        endMinute.value = 0
    }
}