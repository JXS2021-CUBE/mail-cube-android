package com.cube.mailcube.di

import com.cube.mailcube.viewmodel.ContentViewModel
import com.cube.mailcube.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { ContentViewModel() }
}