package com.cube.mailcube.api.model

import com.google.gson.annotations.SerializedName

internal data class Template(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)