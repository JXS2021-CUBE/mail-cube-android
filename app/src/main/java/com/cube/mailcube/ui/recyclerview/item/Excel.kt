package com.cube.mailcube.ui.recyclerview.item

import com.cube.mailcube.base.BaseItem

internal data class Excel(
    val id: Int,
    val name: String,
    override val itemId: String = id.toString()
): BaseItem