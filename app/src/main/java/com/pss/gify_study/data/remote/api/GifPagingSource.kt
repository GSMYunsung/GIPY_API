package com.pss.gify_study.data.remote.api

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pss.gify_study.data.remote.model.Data
import com.pss.gify_study.repository.MainRepository
import com.pss.gify_study.widget.utils.Utils.GIPHY_API_KEY
import com.pss.gify_study.widget.utils.Utils.STARTING_PAGE_INDEX
import java.io.IOException
import javax.inject.Inject

class GifPagingSource @Inject constructor(
    private val gifRepository: MainRepository
    // 처음값은 페이지를 식별하는데 쓰이는 식별자 , 두번째값은 response 데이터 클래스이다.
) : PagingSource<Int,Data>() {

    // 데이터 로드
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val position = params.key ?: STARTING_PAGE_INDEX

            Log.d("TAGING", "offset = $position")

            val response = gifRepository.getGiphyApi(
                key = GIPHY_API_KEY,
                limit = 20,
                offset = (position*20).toString(),
                lang = "ko",
                bundle = "messaging_non_clips"
            )

            val post = response.body()

            /* 로드에 성공 시 LoadResult.Page 반환
            data : 전송되는 데이터
            prevKey : 이전 값 (위 스크롤 방향)
            nextKey : 다음 값 (아래 스크롤 방향)
             */

            LoadResult.Page(
                data = post!!.data,
                prevKey = null,
                nextKey = position + 1
             )

        }

        // 로드에 실패 시 LoadResult.Error 반환
        catch (e : IOException){
            LoadResult.Error(e)
        }
    }

    // 데이터가 새로고침되거나 첫 로드 후 무효화되었을 때 키를 반환하여 load()로 전달

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}