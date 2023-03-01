package com.example.databindingwithlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingwithlivedata.databinding.ActivityMainBinding
import com.example.databindingwithlivedata.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
        setData()
        initObserver()
        binding.executePendingBindings()
    }

    private fun initView() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

    }

    private fun setData() {
        mainViewModel.titleMutableLiveData.value = "Change data"
    }

    private fun initObserver() {
        mainViewModel.titleLiveData.observe(this) {
            binding.tvTitle.text = it
        }

    }
}