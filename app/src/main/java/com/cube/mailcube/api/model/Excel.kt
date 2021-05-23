package com.cube.mailcube.api.model

import com.google.gson.annotations.SerializedName

internal data class Excel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("blob_url")
    val blobUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("datetime")
    val datetime: String
)