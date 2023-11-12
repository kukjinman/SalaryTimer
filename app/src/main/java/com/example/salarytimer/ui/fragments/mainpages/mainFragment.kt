package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.salarytimer.R
import com.example.salarytimer.databinding.FragmentMainBinding

class mainFragment : Fragment() {
    val TAG = "mainFragment1"
    private lateinit var binding: FragmentMainBinding
    private val mainFViewModel by lazy {
        ViewModelProvider(requireActivity())[com.example.salarytimer.ui.viewmodel.mainpages.MainFViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        //binding에서의 viewModel을 정해줘야 xml에서 해당 viewModel binding을 사용할 수 있음
        binding.viewModel = mainFViewModel
        binding.lifecycleOwner = requireActivity()

        mainFViewModel.salary.value = binding.salaryInput.text.toString().toInt()
        Log.d(TAG, "[onCreateView] mainFViewModel.salary.value " + mainFViewModel.salary.value)

        binding.salaryInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    // s가 null이 아닌 경우에만 실행
                    try {
                        mainFViewModel.salary.value = it.toString().toInt()
                    } catch (e: NumberFormatException) {

                        //toast 메세지 넣기
                    }
                }


            }

        })

        buttonEventListner()



        // Inflate the layout for this fragment
        return binding.root
    }

    fun buttonEventListner()
    {

        binding.memoStartTimeHrUpBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeHrUpBtn clicked ")
            mainFViewModel.startHour.value = mainFViewModel.startHour.value!!.plus(1)
        }

        binding.memoStartTimeHrDownBtn.setOnClickListener{
            Log.d(TAG, "memoStartTimeHrDownBtn clicked ")
            mainFViewModel.startHour.value!!.minus(1)

        }

        binding.memoStartTimeMinUpBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeMinUpBtn clicked ")
            mainFViewModel.startMinute.value!!.plus(1)

        }

        binding.memoStartTimeMinDownBtn.setOnClickListener{
            Log.d(TAG, "memoStartTimeMinDownBtn clicked ")
            mainFViewModel.startMinute.value!!.minus(1)

        }
        binding.memoEndTimeHrUpBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeHrUpBtn clicked ")
            mainFViewModel.endHour.value!!.plus(1)

        }

        binding.memoEndTimeHrDownBtn.setOnClickListener{
            Log.d(TAG, "memoEndTimeHrDownBtn clicked ")
            mainFViewModel.endHour.value!!.minus(1)

        }
        binding.memoEndTimeMinUpBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeMinUpBtn clicked ")
            mainFViewModel.endMinute.value!!.plus(1)

        }

        binding.memoEndTimeMinDownBtn.setOnClickListener{
            Log.d(TAG, "memoEndTimeMinDownBtn clicked ")
            mainFViewModel.endMinute.value!!.minus(1)

        }

        mainFViewModel.startHour.observe(requireActivity()){
            Log.d(TAG, "startHour updated : " + mainFViewModel.startHour.value!!.toInt())


        }
    }


}


