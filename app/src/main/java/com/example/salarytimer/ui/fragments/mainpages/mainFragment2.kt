package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.salarytimer.R
import com.example.salarytimer.ui.viewmodel.mainpages.mainF2ViewModel
import com.example.salarytimer.ui.viewmodel.mainpages.mainFViewModel
import java.util.Calendar

class mainFragment2 : Fragment() {
    lateinit var mainFViewModel: mainFViewModel
    lateinit var mainF2ViewModel: mainF2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mainFViewModel = ViewModelProvider(this).get(mainFViewModel::class.java)
//        mainF2ViewModel = ViewModelProvider(this).get(mainF2ViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainFViewModel.salary.observe(viewLifecycleOwner) {
            mainF2ViewModel.todaysalary.value = calTodaySalary(mainF2ViewModel.todaysalary.value!!.toInt())

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }


    fun calTodaySalary(sal: Int): Int {
        var result : Int = 0

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                val now = Calendar.getInstance()
                if (now.get(Calendar.DAY_OF_WEEK) in Calendar.MONDAY..Calendar.FRIDAY) {
                    val weekdaysInMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH)
                    val dailySalary = sal / weekdaysInMonth
                    val worktimesecond = now.get(Calendar.SECOND)
                    val todaySalary = dailySalary * worktimesecond
                    result = todaySalary
                }
                handler.postDelayed(this, 1000) // 1초마다 업데이트
            }
        }

        handler.post(runnable)

        return result
    }

}