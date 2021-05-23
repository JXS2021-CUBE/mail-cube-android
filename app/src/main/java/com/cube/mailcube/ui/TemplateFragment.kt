package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentTemplateBinding
import com.cube.mailcube.extension.observe
import com.cube.mailcube.ui.recyclerview.adapter.TemplateAdapter
import com.cube.mailcube.ui.recyclerview.item.Template
import com.cube.mailcube.viewmodel.ContentViewModel

internal class TemplateFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentTemplateBinding>() {
    override val layoutId = R.layout.fragment_template
    override var viewModel: ContentViewModel? = null

    private lateinit var templateAdapter: TemplateAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserve()
        setSpinner()
        setAdapter()
    }

    private fun setSpinner() {
        templateAdapter = TemplateAdapter(viewModel)
        binding.spinnerLayout.setOnClickListener {
            viewModel?.loadTemplateList()
        }
    }

    private fun setAdapter() {
        with(binding.spinnerRv) { adapter = templateAdapter }
    }

    private fun setObserve() {
        viewModel?.run {
            observe(templateList) {
                setTemplateList(it.map { t ->
                    Template(
                        t.id,
                        t.title,
                        t.content
                    )
                })
            }
            observe(isShowTemplateDropdown) {
                binding.spinnerRv.visibility = when (it) {
                    true -> View.VISIBLE
                    false -> View.GONE
                }
            }
        }
    }

    private fun setTemplateList(list: List<Template>) {
        templateAdapter.submitList(list)
    }
}