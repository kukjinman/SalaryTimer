package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.salarytimer.R
import com.example.salarytimer.databinding.FragmentMain2Binding
import com.example.salarytimer.databinding.FragmentMain3Binding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main3, container, false)
    }

}