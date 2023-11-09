package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.salarytimer.R
import com.example.salarytimer.ui.viewmodel.mainpages.mainF2ViewModel
import java.util.Calendar

class mainFragment2 : Fragment() {
    val TAG = "mainFragment2"
    val handler = Handler(Looper.getMainLooper())

    private val mainFViewModel by lazy {
        ViewModelProvider(this).get(com.example.salarytimer.ui.viewmodel.mainpages.mainFViewModel::class.java)
    }
    private val mainF2ViewModel by lazy {
        ViewModelProvider(this).get(mainF2ViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        InitSalaryCounter()
        mainFViewModel.salary.observe(viewLifecycleOwner) {
            mainF2ViewModel.todaysalary.value = calTodaySalary(mainF2ViewModel.todaysalary.value!!.toInt())

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "[onResume]")

        handler.post(runnable)

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "[onPause]")

        handler.removeCallbacks(runnable)

    }


    val runnable = object : Runnable {
        override fun run() {
            val now = Calendar.getInstance()
            Log.d(TAG, "[InitSalaryCounter]")

            Log.d(TAG, "[InitSalaryCounter]" + now.get(Calendar.DAY_OF_WEEK))

            // Calendar.SUNDAY = 1
            // Calendar.MONDAY = 2
            // Calendar.SATURDAY = 7

            if (now.get(Calendar.DAY_OF_WEEK) in Calendar.MONDAY..Calendar.FRIDAY) {
                // 주중


            }
            else
            {
                // 주말

            }
            handler.postDelayed(this, 1000) // 1초마다 업데이트
        }
    }
    fun InitSalaryCounter() {


        handler.post(runnable)
    }

    fun calTodaySalary(sal: Int): Int {
        var result : Int = 0

        //                    val weekdaysInMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH)
//                    val dailySalary = sal / weekdaysInMonth
//                    val worktimesecond = now.get(Calendar.SECOND)
//                    val todaySalary = dailySalary * worktimesecond
//                    result = todaySalary

        return result
    }

}