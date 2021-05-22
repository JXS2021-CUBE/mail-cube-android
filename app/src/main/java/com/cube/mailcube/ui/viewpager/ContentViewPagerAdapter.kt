package com.cube.mailcube.ui.viewpager

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cube.mailcube.ui.ApplicantFragment
import com.cube.mailcube.ui.TemplateFragment
import com.cube.mailcube.ui.menu.ContentMenu
import com.cube.mailcube.viewmodel.ContentViewModel

internal class ContentViewPagerAdapter(fa: FragmentActivity, private val vm: ContentViewModel) :
    FragmentStateAdapter(fa) {
    override fun getItemCount() = ContentMenu.values().size

    override fun createFragment(position: Int) =
        when (position) {
            APPLICANT_POS -> ApplicantFragment().apply { viewModel = vm }
            TEMPLATE_POS -> TemplateFragment().apply { viewModel = vm }
            else -> ApplicantFragment().apply { viewModel = vm }
        }

    companion object {
        private const val APPLICANT_POS = 0
        private const val TEMPLATE_POS = 1
    }
}