package com.pss.gify_study.data.remote.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("images")
    val images: Images,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)