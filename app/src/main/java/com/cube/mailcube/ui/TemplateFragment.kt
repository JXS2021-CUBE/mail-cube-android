package com.cube.mailcube.ui

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentTemplateBinding
import com.cube.mailcube.viewmodel.ContentViewModel

internal class TemplateFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentTemplateBinding>() {
    override val layoutId = R.layout.fragment_template
    override var viewModel: ContentViewModel? = null
}