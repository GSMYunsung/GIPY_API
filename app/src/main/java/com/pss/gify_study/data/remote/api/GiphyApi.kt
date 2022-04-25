package com.pss.gify_study.data.remote.api

import com.pss.gify_study.data.remote.model.GiphyResponse
import com.pss.gify_study.widget.utils.Utils.END_URL
import com.pss.gify_study.widget.utils.Utils.GIPHY_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GiphyApi{

    @GET(END_URL)
    suspend fun getGiphyGif(
        @Query("api_key") key: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: String,
        @Query("lang") lang: String,
        @Query("bundle") bundle: String
    ) : Response<GiphyResponse>

}