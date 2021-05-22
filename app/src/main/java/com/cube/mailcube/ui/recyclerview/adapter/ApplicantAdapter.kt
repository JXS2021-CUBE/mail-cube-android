package com.cube.mailcube.ui.recyclerview.adapter

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseListAdapter
import com.cube.mailcube.ui.recyclerview.item.Applicant

internal class ApplicantAdapter : BaseListAdapter<Applicant>() {
    override fun getItemViewTypeByItemType(item: Applicant) =
        R.layout.item_applicant
}