package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseFragment
import com.cube.mailcube.databinding.FragmentContentBinding
import com.cube.mailcube.viewmodel.ContentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

internal class ContentFragment : BaseFragment<ContentViewModel, FragmentContentBinding>() {
    override val layoutId = R.layout.fragment_content
    override val viewModel: ContentViewModel by viewModel()
}