package com.cube.mailcube.ui.recyclerview.item

import com.cube.mailcube.base.BaseItem

data class Applicant(
    val name: String,
    val email: String,
    override val itemId: String = email
) : BaseItem