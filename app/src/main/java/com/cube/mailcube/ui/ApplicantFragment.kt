package com.cube.mailcube.ui

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentApplicantBinding
import com.cube.mailcube.viewmodel.ContentViewModel

internal class ApplicantFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentApplicantBinding>() {
    override val layoutId = R.layout.fragment_applicant
    override var viewModel: ContentViewModel? = null
}