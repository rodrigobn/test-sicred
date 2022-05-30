package com.rodrigo.votosassociados.di

import com.rodrigo.votosassociados.ui.dynamicScreens.DynamicViewModel
import com.rodrigo.votosassociados.ui.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { MainViewModel(get()) }
    viewModel { DynamicViewModel(get()) }
}
