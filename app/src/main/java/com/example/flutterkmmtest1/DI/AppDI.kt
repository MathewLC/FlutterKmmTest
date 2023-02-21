package com.example.flutterkmmtest1.DI

import com.example.flutterkmmtest1.viewModel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppDI = module {
    viewModel {
        MainActivityViewModel(get())
    }
}