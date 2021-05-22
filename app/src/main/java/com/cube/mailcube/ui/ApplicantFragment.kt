package com.cube.mailcube.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.cube.mailcube.R
import com.cube.mailcube.base.BaseViewPagerFragment
import com.cube.mailcube.databinding.FragmentApplicantBinding
import com.cube.mailcube.extension.observe
import com.cube.mailcube.ui.recyclerview.adapter.ApplicantAdapter
import com.cube.mailcube.ui.recyclerview.item.Applicant
import com.cube.mailcube.viewmodel.ContentViewModel

internal class ApplicantFragment :
    BaseViewPagerFragment<ContentViewModel, FragmentApplicantBinding>() {
    override val layoutId = R.layout.fragment_applicant
    override var viewModel: ContentViewModel? = null

    private val applicantAdapter = ApplicantAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()
        setAdapter()
        setObserve()
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

    private fun setAdapter() {
        with(binding.rv) {
            adapter = applicantAdapter
        }
    }

    private fun setObserve() {
        viewModel?.applicantList?.let { observe(it) { list -> setApplicantList(list) } }
    }

    private fun setApplicantList(list: List<Applicant>) {
        applicantAdapter.submitList(list)
    }
}