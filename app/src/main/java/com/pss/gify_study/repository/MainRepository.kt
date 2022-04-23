package com.pss.gify_study.repository

import com.pss.gify_study.data.remote.api.GiphyApi
import com.pss.gify_study.data.remote.model.GiphyResponse
import com.pss.gify_study.widget.utils.Utils.GIPHY_API_KEY
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class MainRepository @Inject constructor(
   private val giphyApi: GiphyApi
){

    suspend fun getGiphyApi() : Response<GiphyResponse> = giphyApi.getGiphyGif(key = GIPHY_API_KEY, limit = 20, offset = 0, lang = "ko","messaging")

}