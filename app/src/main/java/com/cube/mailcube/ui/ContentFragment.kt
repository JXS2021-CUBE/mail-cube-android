package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseFragment
import com.cube.mailcube.databinding.FragmentContentBinding
import com.cube.mailcube.ui.menu.ContentMenu
import com.cube.mailcube.ui.viewpager.ContentViewPagerAdapter
import com.cube.mailcube.viewmodel.ContentViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

internal class ContentFragment : BaseFragment<ContentViewModel, FragmentContentBinding>() {
    override val layoutId = R.layout.fragment_content
    override val viewModel: ContentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
    }

    private fun setViewPager() {
        with(binding.viewPager) {
            adapter = ContentViewPagerAdapter(
                requireActivity(),
                viewModel
            )
            TabLayoutMediator(binding.tabLayout, this) { tab, pos ->
                tab.text = ContentMenu.valueOf(ContentMenu.values()[pos].name).menuName
            }.attach()
        }
    }
}