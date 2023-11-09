package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.salarytimer.R
import com.example.salarytimer.databinding.FragmentMainBinding
import com.example.salarytimer.ui.viewmodel.mainpages.mainFViewModel

class mainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainFViewModel: mainFViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mainFViewModel = ViewModelProvider(requireActivity()).get(mainFViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)
//        mainFViewModel.salary.value = binding.salaryInput.text.toString().toInt()

        // Inflate the layout for this fragment
        return binding.root
    }



}