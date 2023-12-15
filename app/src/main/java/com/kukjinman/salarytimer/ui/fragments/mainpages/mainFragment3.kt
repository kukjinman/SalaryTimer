package com.kukjinman.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.salarytimer.R
import com.example.salarytimer.databinding.FragmentMain2Binding
import com.example.salarytimer.databinding.FragmentMain3Binding
import com.example.salarytimer.databinding.FragmentMainBinding
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainF2ViewModel
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainF3ViewModel
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [mainFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class mainFragment3 : Fragment() {
    val TAG = "mainFragment3"
    private lateinit var binding: FragmentMain3Binding
    private val mainF3ViewModel by lazy {
        ViewModelProvider(requireActivity())[MainF3ViewModel::class.java]
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

        binding = DataBindingUtil.inflate<FragmentMain3Binding>(
            inflater,
            R.layout.fragment_main3,
            container,
            false
        )
        binding.viewModel3 = mainF3ViewModel
        binding.lifecycleOwner = requireActivity()


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        displayMonthSalarySum()
    }

    override fun onPause() {
        super.onPause()
    }

    fun displayMonthSalarySum() {
        Log.d(TAG, "[displayMonthSalarySum] is called")

        val now = Calendar.getInstance()
        val today = now.get(Calendar.DAY_OF_MONTH)
        val totalDaysInMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH)

        var weekdaysInMonth = 0

        for (day in 1..today) {
            now.set(Calendar.DAY_OF_MONTH, day)
            val dayOfWeek = now.get(Calendar.DAY_OF_WEEK)

            // 토요일과 일요일을 제외하고 주중의 날짜 수를 증가시킴
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                weekdaysInMonth++
            }
        }

        Log.d(TAG, "weekdaysInMonth till today : $weekdaysInMonth")

        mainF3ViewModel.monthSalarySum.value = mainF2ViewModel.todaysalary.value!!.toInt() * weekdaysInMonth + mainF2ViewModel.todayCurSalary.value!!.toInt()

        Log.d(TAG, "monthSalarySum : " + mainF3ViewModel.monthSalarySum.value!!.toInt())


    }


}