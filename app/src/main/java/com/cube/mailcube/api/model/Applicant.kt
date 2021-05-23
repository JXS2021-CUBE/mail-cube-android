package com.cube.mailcube.api.model

import com.google.gson.annotations.SerializedName

internal data class Applicant(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String
)