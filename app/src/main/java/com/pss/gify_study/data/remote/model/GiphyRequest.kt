package com.pss.gify_study.data.remote.model

import retrofit2.http.Query

data class GiphyRequest (
    val key: String,
    val limit: Int,
    val offset: Int,
    val lang: String,
    val bundle: String,
)