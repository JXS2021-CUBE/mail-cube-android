package com.cube.mailcube.ui

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseActivity
import com.cube.mailcube.databinding.ActivityMainBinding
import com.cube.mailcube.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

internal class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val layoutId = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
}