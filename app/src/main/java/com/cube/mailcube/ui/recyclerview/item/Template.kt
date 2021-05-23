package com.cube.mailcube.ui.recyclerview.item

import com.cube.mailcube.base.BaseItem

internal data class Template(
    val id: Int,
    val title: String,
    val content: String,
    override val itemId: String = id.toString()
) : BaseItem