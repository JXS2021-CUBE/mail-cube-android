package com.cube.mailcube.ui.recyclerview.adapter

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseListAdapter
import com.cube.mailcube.ui.recyclerview.item.Excel
import com.cube.mailcube.viewmodel.ContentViewModel

internal class ExcelAdapter(viewModel: ContentViewModel?) : BaseListAdapter<Excel>() {

    init {
        viewModel?.let {
            setViewModel(it)
        }
    }

    override fun getItemViewTypeByItemType(item: Excel) =
        R.layout.item_excel
}