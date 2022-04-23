package com.pss.gify_study.data.remote.model

data class GiphyResponse(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)