package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentApplicantBinding
import com.cube.mailcube.extension.observe
import com.cube.mailcube.ui.recyclerview.adapter.ApplicantAdapter
import com.cube.mailcube.ui.recyclerview.adapter.ExcelAdapter
import com.cube.mailcube.ui.recyclerview.item.Applicant
import com.cube.mailcube.ui.recyclerview.item.Excel
import com.cube.mailcube.viewmodel.ContentViewModel

internal class ApplicantFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentApplicantBinding>() {
    override val layoutId = R.layout.fragment_applicant
    override var viewModel: ContentViewModel? = null

    private val applicantAdapter = ApplicantAdapter()
    private lateinit var excelAdapter: ExcelAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserve()
        setSpinner()
        setAdapter()
    }

    private fun setSpinner() {
        excelAdapter = ExcelAdapter(viewModel)
        binding.spinnerLayout.setOnClickListener {
            viewModel?.loadExcelList()
        }
    }

    private fun setAdapter() {
        with(binding.rv) { adapter = applicantAdapter }
        with(binding.spinnerRv) { adapter = excelAdapter }
    }

    private fun setObserve() {
        viewModel?.run {
            observe(excelList) { setExcelList(it.map { e -> Excel(e.id, e.name) }) }
            observe(applicantList) { setApplicantList(it) }
            observe(isShowExcelDropdown) {
                binding.spinnerRv.visibility = when (it) {
                    true -> View.VISIBLE
                    false -> View.GONE
                }
            }
        }
    }

    private fun setExcelList(list: List<Excel>) {
        excelAdapter.submitList(list)
    }

    private fun setApplicantList(list: List<Applicant>) {
        applicantAdapter.submitList(list)
    }
}