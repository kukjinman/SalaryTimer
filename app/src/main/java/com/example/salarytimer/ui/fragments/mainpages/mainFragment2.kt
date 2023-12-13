package com.example.salarytimer.ui.fragments.mainpages

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.salarytimer.R
import com.example.salarytimer.databinding.FragmentMain2Binding
import com.example.salarytimer.ui.viewmodel.mainpages.MainF2ViewModel
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import java.util.Calendar

class mainFragment2 : Fragment() {
    val TAG = "mainFragment2"
    private lateinit var binding: FragmentMain2Binding
    val handler = Handler(Looper.getMainLooper())

    private var mInterstitialAd: InterstitialAd? = null

    var addisplaycntdown = 0


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
        Log.d(TAG, "[onCreate]")
        setupInterstitialAd()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentMain2Binding>(
            inflater,
            R.layout.fragment_main2,
            container,
            false
        )

        binding.viewModel2 = mainF2ViewModel
        binding.lifecycleOwner = requireActivity()

        InitSalaryCounter()

        Log.d(TAG, "[onCreateView] mainFViewModel.salary.value : " + mainFViewModel.salary.value)
        mainF2ViewModel.todaysalary.value =
            calTodaySalary(mainFViewModel.salary.value?.toInt() ?: 0)
        Log.d(TAG, "[onCreateView] todaysalary : " + mainF2ViewModel.todaysalary.value)

        mainFViewModel.salary.observe(requireActivity()) {
            mainF2ViewModel.todaysalary.value =
                calTodaySalary(mainFViewModel.salary.value!!.toInt())
            Log.d(TAG, "[onCreateView] updated todaysalary : " + mainF2ViewModel.todaysalary.value)

        }

        //viewModel과 lifecycleOwner가 다 설정된 binding이 return되어야 binding이 정상동작함.
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "[onResume]")
        val now = Calendar.getInstance()

        if (now.get(Calendar.DAY_OF_WEEK) in Calendar.MONDAY..Calendar.FRIDAY) {
            // 주중
            Log.d(TAG, "[InitSalaryCounter] weekdays")

            handler.post(runnable)


        } else {
            // 주말
            Log.d(TAG, "[InitSalaryCounter] weekend")


            handler.removeCallbacks(runnable)


        }
        Log.d(TAG, "[onResume] addisplaycntdown : " + addisplaycntdown)

        if(addisplaycntdown>=3){
            displayAdmob()
            addisplaycntdown = 0
        }
        addisplaycntdown++
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "[onPause]")

        handler.removeCallbacks(runnable)

    }


    val runnable = object : Runnable {
        override fun run() {


            val now = Calendar.getInstance()

            if (mainFViewModel.endHour.value!!.toInt() <= now.get(Calendar.HOUR_OF_DAY)) {
                if (mainFViewModel.endMinute.value!!.toInt() <= now.get(Calendar.MINUTE)) {
                    Log.d(TAG, "[InitSalaryCounter] work hour done")
                    mainF2ViewModel.todayCurSalary.value =
                        mainF2ViewModel.todaysalary.value!!.toInt()

                } else {
                    displayTodaySalary()
                }
            } else if (mainFViewModel.startHour.value!!.toInt() > now.get(Calendar.HOUR_OF_DAY)) {

                Log.d(TAG, "[InitSalaryCounter] work hour not begins")
                mainF2ViewModel.todayCurSalary.value = 0

            } else {
                displayTodaySalary()

            }

            handler.postDelayed(this, 1000) // 1초마다 업데이트
        }
    }

    private fun InitSalaryCounter() {

        val now = Calendar.getInstance()
        Log.d(TAG, "[InitSalaryCounter]")

        Log.d(TAG, "[InitSalaryCounter]" + now.get(Calendar.DAY_OF_WEEK))

        // Calendar.SUNDAY = 1
        // Calendar.MONDAY = 2
        // Calendar.SATURDAY = 7

        if (now.get(Calendar.DAY_OF_WEEK) in Calendar.MONDAY..Calendar.FRIDAY) {
            // 주중
            Log.d(TAG, "[InitSalaryCounter] weekdays")
            handler.post(runnable)
        } else {
            // 주말
            Log.d(TAG, "[InitSalaryCounter] weekend")
            handler.removeCallbacks(runnable)
        }

    }

    fun calTodaySalary(sal: Int): Int {
        val now = Calendar.getInstance()
        val totalDaysInMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH)

        var weekdaysInMonth = 0

        for (day in 1..totalDaysInMonth) {
            now.set(Calendar.DAY_OF_MONTH, day)
            val dayOfWeek = now.get(Calendar.DAY_OF_WEEK)

            // 토요일과 일요일을 제외하고 주중의 날짜 수를 증가시킴
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                weekdaysInMonth++
            }
        }


        Log.d(TAG, "[calTodaySalary] weekdaysInMonth : $weekdaysInMonth")
        Log.d(TAG, "[calTodaySalary] sal : $sal")

        return sal / weekdaysInMonth
    }

    fun displayTodaySalary() {
        Log.d(TAG, "[displayTodaySalary] is called")
        val now = Calendar.getInstance()
        Log.d(TAG, "[displayTodaySalary] date : ${now.get(Calendar.DATE)}")

        var todaySecond = 0;

        var curHour = now.get(Calendar.HOUR_OF_DAY)
        var curMin = now.get(Calendar.MINUTE)
        var curSec = now.get(Calendar.SECOND)

        todaySecond =
            (curHour.toInt() - mainFViewModel.startHour.value!!.toInt()) * 3600 + (curMin.toInt() - mainFViewModel.startMinute.value!!.toInt()) * 60 + curSec.toInt()

        Log.d(TAG, "[displayTodaySalary] todaySecond : $todaySecond")

        var todayWorkSecond =
            (mainFViewModel.endHour.value!!.toInt() - mainFViewModel.startHour.value!!.toInt()) * 3600 + (mainFViewModel.endMinute.value!!.toInt() - mainFViewModel.startMinute.value!!.toInt()) * 60

        Log.d(TAG, "[displayTodaySalary] todayWorkSecond : $todayWorkSecond")

        mainF2ViewModel.todayCurSalary.value =
            mainF2ViewModel.todaysalary.value!!.toInt() / todayWorkSecond.toInt() * todaySecond.toInt()


    }

    fun displayAdmob(){

        if (mInterstitialAd != null) {
            mInterstitialAd?.show(requireActivity())
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    Log.d("DEBUG: ", "Ad was clicked.")
                }

                override fun onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    Log.d("DEBUG: ", "Ad dismissed fullscreen content.")
                    mInterstitialAd = null
                    setupInterstitialAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.e("DEBUG: ", "Ad failed to show fullscreen content.")
                    mInterstitialAd = null
                }

                override fun onAdImpression() {
                    Log.d("DEBUG: ", "Ad recorded an impression.")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d("DEBUG: ", "Ad showed fullscreen content.")
                }
            }
        } else {
        }

    }


    private fun setupInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(),
            "ca-app-pub-5898839142087215/4615616011",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("DEBUG: ", adError?.message.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("DEBUG: ", "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }
            })
    }

}