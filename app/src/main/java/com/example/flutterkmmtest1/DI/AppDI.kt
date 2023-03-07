package com.example.flutterkmmtest1.DI

import com.example.flutterkmmtest1.pigeons.PizzaHostApi
import com.example.flutterkmmtest1.viewModel.MainActivityViewModel
import com.example.flutterkmmtest1.viewModel.Page2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppDI = module {
    viewModel {
        MainActivityViewModel(get())
    }

    viewModel {
        Page2ViewModel(get())
    }

}