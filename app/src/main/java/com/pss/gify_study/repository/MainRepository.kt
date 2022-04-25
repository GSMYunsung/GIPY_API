package com.pss.gify_study.repository

import com.pss.gify_study.data.remote.api.GiphyApi
import com.pss.gify_study.data.remote.model.GiphyResponse
import com.pss.gify_study.widget.utils.Utils.GIPHY_API_KEY
import retrofit2.Response
import retrofit2.http.Query
import java.util.*
import javax.inject.Inject

class MainRepository @Inject constructor(
   private val giphyApi: GiphyApi
){

    suspend fun getGiphyApi(key : String, limit : Int, offset : String, lang : String, bundle: String) : Response<GiphyResponse> = giphyApi.getGiphyGif(key = key, limit = limit, offset = offset, lang = lang,bundle)

}