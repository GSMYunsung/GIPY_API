package com.pss.gify_study.data.remote.model


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidth,
)