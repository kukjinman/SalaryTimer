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
import com.example.salarytimer.ui.viewmodel.mainpages.MainF2ViewModel
import java.util.Calendar

class mainFragment2 : Fragment() {
    val TAG = "mainFragment2"
    val handler = Handler(Looper.getMainLooper())

    //ViewModelProvider의 현재 초기화 방식은 androidx.lifecycle:lifecycle-viewmodel과 다른 방식임
    //ViewModelProvider의 owner인자로 requireActivity()을 사용해줘야 다른 곳에서도 해당 viewmodel instance사용시
    //싱글톤으로 사용이 가능하다 owner를 다르게해주면 새로운 instance로 생성됩
    private val mainFViewModel by lazy {
        ViewModelProvider(requireActivity())[com.example.salarytimer.ui.viewmodel.mainpages.MainFViewModel::class.java]
    }
    private val mainF2ViewModel by lazy {
        ViewModelProvider(requireActivity())[MainF2ViewModel::class.java]

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        InitSalaryCounter()

        Log.d(TAG, "[onCreateView] mainFViewModel.salary.value : " + mainFViewModel.salary.value)
        mainF2ViewModel.todaysalary.value = calTodaySalary(mainFViewModel.salary.value?.toInt() ?: 0)
        Log.d(TAG, "[onCreateView] todaysalary : " + mainF2ViewModel.todaysalary.value)

        mainFViewModel.salary.observe(requireActivity()) {
            mainF2ViewModel.todaysalary.value = calTodaySalary(mainFViewModel.salary.value!!.toInt())
            Log.d(TAG, "[onCreateView] updated todaysalary : " + mainF2ViewModel.todaysalary.value)

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
                Log.d(TAG, "[InitSalaryCounter] weekdays")

            }
            else
            {
                // 주말
                Log.d(TAG, "[InitSalaryCounter] weekend")


            }
            handler.postDelayed(this, 1000) // 1초마다 업데이트
        }
    }
    private fun InitSalaryCounter() {


        handler.post(runnable)
    }

    fun calTodaySalary(sal: Int): Int {
        var result : Int = 0
        val now = Calendar.getInstance()
        val weekdaysInMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH)
        Log.d(TAG, "[calTodaySalary] weekdaysInMonth : $weekdaysInMonth")
        Log.d(TAG, "[calTodaySalary] sal : $sal")

        val dailySalary = sal / weekdaysInMonth

//                    val dailySalary = sal / weekdaysInMonth
//                    val worktimesecond = now.get(Calendar.SECOND)
//                    val todaySalary = dailySalary * worktimesecond
//                    result = todaySalary

        return dailySalary
    }

}