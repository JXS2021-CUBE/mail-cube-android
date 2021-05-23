package com.cube.mailcube.ui.recyclerview.adapter

import com.cube.mailcube.R
import com.cube.mailcube.base.BaseListAdapter
import com.cube.mailcube.ui.recyclerview.item.Template
import com.cube.mailcube.viewmodel.ContentViewModel

internal class TemplateAdapter(viewModel: ContentViewModel?) : BaseListAdapter<Template>() {

    init {
        viewModel?.let {
            setViewModel(it)
        }
    }

    override fun getItemViewTypeByItemType(item: Template) =
        R.layout.item_template
}