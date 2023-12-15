package com.kukjinman.salarytimer.ui.viewmodel.mainpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainFViewModel : ViewModel() {

    var salary = MutableLiveData<Number>()

    var startHour = MutableLiveData<String>()
    var startMinute = MutableLiveData<String>()
    var endHour = MutableLiveData<String>()
    var endMinute = MutableLiveData<String>()



    init {
        salary.value = 3000000

        startHour.value = "09"
        startMinute.value = "00"
        endHour.value = "17"
        endMinute.value = "00"
    }
}