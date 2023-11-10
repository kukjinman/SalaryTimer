package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
        mainFViewModel.salary.value = binding.salaryInput.text.toString().toInt()
        Log.d(TAG, "[onCreateView] mainFViewModel.salary.value " + mainFViewModel.salary.value)

        binding.salaryInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    // s가 null이 아닌 경우에만 실행
                    try {
                        val enteredValue = it.toString().toInt()
                        mainFViewModel.salary.value = enteredValue
                    } catch (e: NumberFormatException) {
                        // 사용자가 숫자가 아닌 값을 입력한 경우 예외 처리
                        // 원하는 방식으로 처리하거나 에러 메시지를 표시할 수 있습니다.
                    }
                }


            }

        })


        // Inflate the layout for this fragment
        return binding.root
    }



}