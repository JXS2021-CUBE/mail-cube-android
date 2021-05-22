package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentTemplateBinding
import com.cube.mailcube.viewmodel.ContentViewModel

internal class TemplateFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentTemplateBinding>() {
    override val layoutId = R.layout.fragment_template
    override var viewModel: ContentViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()
    }

    private fun setSpinner() {
        val list = listOf("1", "2", "3")
        binding.spinner.adapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                list
            )
    }
}