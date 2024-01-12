package com.kukjinman.salarytimer.ui.fragments.mainpages

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

import com.kukjinman.salarytimer.R
import com.kukjinman.salarytimer.databinding.FragmentMainBinding
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.kukjinman.salarytimer.ui.viewmodel.mainpages.MainFViewModel

class mainFragment : Fragment() {
    val TAG = "mainFragment1"

    private lateinit var binding: FragmentMainBinding
    private val mainFViewModel by lazy {
        ViewModelProvider(requireActivity())[MainFViewModel::class.java]
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
        //binding을하는 xml 안에서 variable로 viewModel을 선언해줬음
        //해당 variable에 대한 객체를 넘겨 줘야 비로소 binding이 완성 됨
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

    fun buttonEventListner() {

        binding.memoStartTimeHrUpBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeHrUpBtn clicked ")

            if (mainFViewModel.startHour.value!!.toInt() >= 23) {
                mainFViewModel.startHour.value = "00"
            } else {
                mainFViewModel.startHour.value = String.format("%02d", mainFViewModel.startHour.value!!.toInt() + 1)

            }
        }

        binding.memoStartTimeHrDownBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeHrDownBtn clicked ")
            if (mainFViewModel.startHour.value!!.toInt() <= 0) {
                mainFViewModel.startHour.value = "23"
            } else {
                mainFViewModel.startHour.value = String.format("%02d", mainFViewModel.startHour.value!!.toInt() - 1)
            }


        }

        binding.memoStartTimeMinUpBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeMinUpBtn clicked ")

            if (mainFViewModel.startMinute.value!!.toInt() >= 59) {
                mainFViewModel.startMinute.value = "00"
            } else {
                mainFViewModel.startMinute.value = String.format("%02d", mainFViewModel.startMinute.value!!.toInt() + 1)
            }


        }

        binding.memoStartTimeMinDownBtn.setOnClickListener {
            Log.d(TAG, "memoStartTimeMinDownBtn clicked ")

            if (mainFViewModel.startMinute.value!!.toInt() <= 0) {
                mainFViewModel.startMinute.value = "59"
            } else {
                mainFViewModel.startMinute.value = String.format("%02d", mainFViewModel.startMinute.value!!.toInt() - 1)
            }


        }
        binding.memoEndTimeHrUpBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeHrUpBtn clicked ")

            if (mainFViewModel.endHour.value!!.toInt() >= 23) {
                mainFViewModel.endHour.value = "00"
            } else {
                mainFViewModel.endHour.value = String.format("%02d",mainFViewModel.endHour.value!!.toInt() + 1)
            }

        }

        binding.memoEndTimeHrDownBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeHrDownBtn clicked ")

            if (mainFViewModel.endHour.value!!.toInt() <= 0) {
                mainFViewModel.endHour.value = "23"
            } else {
                mainFViewModel.endHour.value = String.format("%02d", mainFViewModel.endHour.value!!.toInt() - 1)
            }


        }
        binding.memoEndTimeMinUpBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeMinUpBtn clicked ")


            if (mainFViewModel.endMinute.value!!.toInt() >= 59) {
                mainFViewModel.endMinute.value = "00"
            } else {
                mainFViewModel.endMinute.value = String.format("%02d",mainFViewModel.endMinute.value!!.toInt() + 1)
            }


        }

        binding.memoEndTimeMinDownBtn.setOnClickListener {
            Log.d(TAG, "memoEndTimeMinDownBtn clicked ")

            if (mainFViewModel.endMinute.value!!.toInt() <= 0) {
                mainFViewModel.endMinute.value = "59"
            } else {
                mainFViewModel.endMinute.value = String.format("%02d", mainFViewModel.endMinute.value!!.toInt() - 1)
            }


        }

        mainFViewModel.startHour.observe(requireActivity()) {
            Log.d(TAG, "startHour updated : " + mainFViewModel.startHour.value!!.toInt())


        }
    }


}


