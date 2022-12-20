package com.example.geoquizz

import android.app.Application

class MyApplication : Application() {
    lateinit var viewModel: CustomViewModel.MyViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = CustomViewModel.MyViewModel(
            Repository.Base())
    }
}